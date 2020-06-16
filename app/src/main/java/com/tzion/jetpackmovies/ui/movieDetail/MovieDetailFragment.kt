package com.tzion.jetpackmovies.ui.movieDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.tzion.jetpackmovies.JetpackMoviesApp
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.databinding.FragmentMovieDetailBinding
import com.tzion.jetpackmovies.ui.di.ViewModelFactory
import com.tzion.jetpackmovies.presentation.MovieDetailViewModel
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import com.tzion.jetpackmovies.ui.di.module.DaggerMoviesComponent
import com.tzion.jetpackmovies.ui.mapper.AttrsMapper
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MovieDetailFragment: Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var attrsMapper: AttrsMapper
    private val movieDetailViewModel: MovieDetailViewModel? by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(MovieDetailViewModel::class.java)
    }
    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var movieDetailDisplayed: UiMovieDetail
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDependencyInjection()
        setupViewModel()
        loadMovieDetailById()
    }

    private fun setupDependencyInjection() {
        val applicationComponent = (activity?.applicationContext as JetpackMoviesApp).appComponent
        DaggerMoviesComponent.factory().create(applicationComponent).inject(this)
    }

    private fun setupViewModel() {
        movieDetailViewModel?.getLiveData()?.observe(this, Observer { renderUiState(it) })
    }

    private fun renderUiState(uiState: MovieDetailUiState) {
        updateScreenForLoading(uiState.loading)
        updateScreenForSuccess(uiState.movieDetail)
        updateScreenForError(uiState.error)
    }

    private fun updateScreenForLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                svDetailMovie.visibility = View.GONE
                pbMovieDetail.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                svDetailMovie.visibility = View.VISIBLE
                pbMovieDetail.visibility = View.GONE
            }
        }
    }

    private fun updateScreenForSuccess(movieDetail: UiMovieDetail) {
        movieDetailDisplayed = movieDetail
        binding.attrsDetailTemplate = with(attrsMapper) { movieDetail.fromUiToAttrs() }
    }

    private fun updateScreenForError(error: Throwable?) {
        error?.let {
            Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun loadMovieDetailById() {
        movieDetailViewModel?.loadMovieDetailById(args.movieId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                setDisplayedMovieAsFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setDisplayedMovieAsFavorite() {
        movieDetailViewModel?.addMovieToFavorites(movieDetailDisplayed)
        makeFavoriteConfirmationMsg()
    }

    private fun makeFavoriteConfirmationMsg() {
        Snackbar.make(
            binding.root,
            getString(R.string.was_added_to_your_favorite_movie_list, binding.templateDetailMovie.getTitle()),
            Snackbar.LENGTH_LONG
        ).setAction(R.string.undo) {
            Timber.d("Action for Snackbar")
        }.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        fun makeIntent(context: Context?, movieId: String): Intent? = context?.let {
            Intent(context, MovieDetailFragment::class.java)
        }

    }

}
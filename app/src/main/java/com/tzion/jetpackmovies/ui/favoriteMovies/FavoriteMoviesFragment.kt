package com.tzion.jetpackmovies.ui.favoriteMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tzion.jetpackmovies.databinding.FragmentFavoriteMoviesBinding
import com.tzion.jetpackmovies.presentation.FavoriteMovieViewModel
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import com.tzion.jetpackmovies.presentation.uistates.FavoriteMovieUiState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMoviesFragment: Fragment() {

    @Inject lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter
    private val favoriteMoviesViewModel: FavoriteMovieViewModel? by viewModels()
    lateinit var binding: FragmentFavoriteMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        setupFragment()
        return binding.root
    }

    private fun setupFragment() {
        setUpRecyclerView()
        observeFavoriteMovieViewModel()
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvFavoriteMovies.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            binding.rvFavoriteMovies.itemAnimator = DefaultItemAnimator()
            binding.rvFavoriteMovies.adapter = favoriteMoviesAdapter
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun observeFavoriteMovieViewModel() {
        favoriteMoviesViewModel
            ?.favoriteMoviesLiveData()
            ?.observe(viewLifecycleOwner, Observer { updateFavoriteMovieAdapter(it) })
    }

    private fun updateFavoriteMovieAdapter(movies: PagedList<UiFavoriteMovie>) {
        favoriteMoviesAdapter.submitList(movies)
    }

    private fun renderUiState(uiState: FavoriteMovieUiState) {
        updateScreenForLoading(uiState.loading)
        updateScreenForSuccess(uiState.favoriteMovies)
        updateScreenForError(uiState.error)
    }

    private fun updateScreenForLoading(loading: Boolean) {
        if (loading) {
            binding.apply {
                pbFavoriteMovies.visibility = View.VISIBLE
                rvFavoriteMovies.visibility = View.GONE
            }
        } else {
            binding.apply {
                pbFavoriteMovies.visibility = View.GONE
                rvFavoriteMovies.visibility = View.VISIBLE
            }
        }
    }

    private fun updateScreenForSuccess(movies: PagedList<UiFavoriteMovie>?) {
        movies?.let {
            favoriteMoviesAdapter.submitList(it)
        }
    }

    private fun updateScreenForError(error: Throwable?) {
        error?.let {
            Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

}
package com.tzion.jetpackmovies.ui.findMovies

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tzion.jetpackmovies.JetpackMoviesApp
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.databinding.FragmentFindMoviesByNameBinding
import com.tzion.jetpackmovies.ui.di.ViewModelFactory
import com.tzion.jetpackmovies.presentation.FindMoviesViewModel
import com.tzion.jetpackmovies.presentation.MainViewModel
import com.tzion.jetpackmovies.presentation.model.UiMovie
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import com.tzion.jetpackmovies.ui.di.DaggerApplicationComponent
import com.tzion.jetpackmovies.ui.di.module.DaggerMoviesComponent
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class FindMoviesByNameFragment: Fragment() {

    @Inject lateinit var displayMoviesAdapter: DisplayMoviesAdapter
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val findMoviesViewModel: FindMoviesViewModel? by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(FindMoviesViewModel::class.java)
    }
    private val mainViewModel: MainViewModel? by lazy {
        activity?.let { fragmentActivity ->
            ViewModelProviders
                .of(fragmentActivity, viewModelFactory)
                .get(MainViewModel::class.java)
        }
    }
    private lateinit var binding: FragmentFindMoviesByNameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFindMoviesByNameBinding.inflate(inflater, container, false)
        setupFragment()
        return binding.root
    }

    private fun setupFragment() {
        setupDependencyInjection()
        setUpRecyclerView()
        observeMainViewModel()
        observeFindMoviesViewModel()
    }

    private fun setupDependencyInjection() {
        val applicationComponent = (activity?.applicationContext as JetpackMoviesApp).appComponent
        DaggerMoviesComponent.factory().create(applicationComponent).inject(this)
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvDisplayMovies.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            binding.rvDisplayMovies.itemAnimator = DefaultItemAnimator()
            binding.rvDisplayMovies.adapter = displayMoviesAdapter
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun observeMainViewModel() {
        mainViewModel?.getFindMovieQueryLiveData()?.observe(this, Observer { findMoviesByName(it) })
    }

    private fun findMoviesByName(name: String?) {
        findMoviesViewModel?.findMoviesByName(name)
    }

    private fun observeFindMoviesViewModel() {
        findMoviesViewModel?.getLiveData()?.observe(this, Observer { renderUiState(it) })
    }

    private fun renderUiState(uiState: FindMoviesUiState) {
        updateScreenForLoading(uiState.loading)
        updateScreenForSuccess(uiState.movies)
        updateScreenForError(uiState.error)
    }

    private fun updateScreenForLoading(loading: Boolean) {
        if (loading) {
            binding.pbDisplayMovies.visibility = View.VISIBLE
            binding.gMakeSearch.visibility = View.VISIBLE
            binding.rvDisplayMovies.visibility = View.GONE
        } else {
            binding.pbDisplayMovies.visibility = View.GONE
            binding.gMakeSearch.visibility = View.GONE
            binding.rvDisplayMovies.visibility = View.VISIBLE
        }
    }

    private fun updateScreenForSuccess(movies: List<UiMovie>) {
        displayMoviesAdapter.setData(movies)
    }

    private fun updateScreenForError(error: Throwable?) {
        error?.let {
            Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

}
package com.tzion.openmoviesdatabase.movies.ui.displayMovies

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tzion.openmoviesdatabase.R
import com.tzion.openmoviesdatabase.databinding.ActivityDisplayMoviesByNameBinding
import com.tzion.openmoviesdatabase.di.ViewModelFactory
import com.tzion.openmoviesdatabase.movies.presentation.FindMoviesViewModel
import com.tzion.openmoviesdatabase.movies.presentation.model.UiMovie
import com.tzion.openmoviesdatabase.movies.presentation.uistates.FindMoviesUiState
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DisplayMoviesByNameActivity: AppCompatActivity() {

    @Inject lateinit var displayMoviesAdapter: DisplayMoviesAdapter
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val findMoviesViewModel: FindMoviesViewModel? by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(FindMoviesViewModel::class.java)
    }
    private lateinit var binding: ActivityDisplayMoviesByNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_movies_by_name)
        setupDependencyInjection()
        setUpRecyclerView()
    }

    private fun setupDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvDisplayMovies.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
            binding.rvDisplayMovies.itemAnimator = DefaultItemAnimator()
            binding.rvDisplayMovies.adapter = displayMoviesAdapter
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_movies_menu, menu)
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(text: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(text: String?): Boolean {
                findMoviesByName(text)
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun findMoviesByName(name: String?) {
        findMoviesViewModel?.getLiveData()?.observe(this, Observer { renderUiState(it) })
        findMoviesViewModel?.findMoviesByName(name)
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
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

}
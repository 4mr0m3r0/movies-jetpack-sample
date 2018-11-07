package com.tzion.openmoviesdatabase.movie.displayMovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tzion.openmoviesdatabase.R
import com.tzion.openmoviesdatabase.databinding.ActivityDisplayMoviesBinding
import com.tzion.openmoviesdatabase.di.ViewModelFactory
import com.tzion.openmoviesdatabase.movie.MovieViewMapper
import com.tzion.openmoviesdatabase.movie.model.MovieView
import com.tzion.presentation.Resource
import com.tzion.presentation.ResourceState
import com.tzion.presentation.movie.FindMoviesViewModel
import com.tzion.presentation.movie.model.MoviePresentation
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DisplayMoviesActivity : AppCompatActivity() {

    @Inject lateinit var displayMoviesAdapter: DisplayMoviesAdapter
    @Inject lateinit var mapper: MovieViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var findMoviesViewModel: FindMoviesViewModel
    private lateinit var binding: ActivityDisplayMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_display_movies)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_movies)
        AndroidInjection.inject(this)
        setUpView()
    }

    private fun setUpView() {
        setUpViewModelProvider()
        setUpRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.find_movies_menu, menu)
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(text: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(text: String?): Boolean {
                findMoviesByText(text)
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

    private fun setUpViewModelProvider() {
        findMoviesViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(FindMoviesViewModel::class.java)
    }

    private fun setUpRecyclerView() {
        try {
            binding.rvDisplayMovies.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
            binding.rvDisplayMovies.itemAnimator = DefaultItemAnimator()
            binding.rvDisplayMovies.adapter = displayMoviesAdapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun findMoviesByText(text: String?) {
        findMoviesViewModel.getMoviesLiveData().observe(this,
                Observer<Resource<List<MoviePresentation>>> {
                    it?.let {
                        handleDataState(it)
                    }
                })
        findMoviesViewModel.findMoviesByText(text)
    }

    private fun handleDataState(resource: Resource<List<MoviePresentation>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                binding.pbDisplayMovies.visibility = View.VISIBLE
                binding.gMakeSearch.visibility = View.GONE
            }
            ResourceState.ERROR -> {
                binding.pbDisplayMovies.visibility = View.GONE
                binding.gMakeSearch.visibility = View.VISIBLE
                binding.rvDisplayMovies.visibility = View.GONE
            }
        }
    }

    private fun setScreenForSuccess(clients: List<MovieView>?) {
        binding.pbDisplayMovies.visibility = View.GONE
        clients?.let {
            displayMoviesAdapter.setData(it)
            binding.gMakeSearch.visibility = View.GONE
            binding.rvDisplayMovies.visibility = View.VISIBLE
        } ?: run {
            Timber.d("setScreenForSuccess empty list")
            binding.gMakeSearch.visibility = View.VISIBLE
        }


    }
}

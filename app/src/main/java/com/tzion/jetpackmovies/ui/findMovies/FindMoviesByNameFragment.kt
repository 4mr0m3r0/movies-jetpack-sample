package com.tzion.jetpackmovies.ui.findMovies
//TODO: Remove this file
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.Menu
//import android.view.MenuInflater
//import android.view.MenuItem
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.appcompat.widget.SearchView
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.DefaultItemAnimator
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.tzion.jetpackmovies.R
//import com.tzion.jetpackmovies.databinding.FragmentFindMoviesByNameBinding
//import com.tzion.jetpackmovies.presentation.FindMoviesViewModel
//import com.tzion.jetpackmovies.presentation.model.Movie
//import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
//import dagger.hilt.android.AndroidEntryPoint
//import javax.inject.Inject

//@AndroidEntryPoint
//class FindMoviesByNameFragment : Fragment() {
//
//    @Inject
//    lateinit var findMoviesByNameAdapter: FindMoviesByNameAdapter
//    private val findMoviesViewModel by viewModels<FindMoviesViewModel>()
//    private lateinit var binding: FragmentFindMoviesByNameBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentFindMoviesByNameBinding.inflate(inflater, container, false)
//        setHasOptionsMenu(true)
//        setupFragment()
//        return binding.root
//    }
//
//    private fun setupFragment() {
//        setUpRecyclerView()
//        observeFindMoviesViewModel()
//    }
//
//    private fun setUpRecyclerView() {
//        binding.rvDisplayMovies.addItemDecoration(
//            DividerItemDecoration(
//                context,
//                LinearLayoutManager.VERTICAL
//            )
//        )
//        binding.rvDisplayMovies.itemAnimator = DefaultItemAnimator()
//        binding.rvDisplayMovies.adapter = findMoviesByNameAdapter
//    }
//
//    private fun observeFindMoviesViewModel() {
//        findMoviesViewModel.getLiveData()
//            .observe(viewLifecycleOwner, Observer { renderUiState(it) })
//    }
//
//    private fun renderUiState(uiState: FindMoviesUiState) {
//        updateScreenForLoading(uiState.loading)
//        updateScreenForSuccess(uiState.movies)
//        updateScreenForError(uiState.error)
//    }
//
//    private fun updateScreenForLoading(loading: Boolean) {
//        if (loading) {
//            binding.pbDisplayMovies.visibility = View.VISIBLE
//            binding.gMakeSearch.visibility = View.VISIBLE
//            binding.rvDisplayMovies.visibility = View.GONE
//        } else {
//            binding.pbDisplayMovies.visibility = View.GONE
//            binding.gMakeSearch.visibility = View.GONE
//            binding.rvDisplayMovies.visibility = View.VISIBLE
//        }
//    }
//
//    private fun updateScreenForSuccess(movies: List<Movie>) {
//        findMoviesByNameAdapter.setData(movies)
//    }
//
//    private fun updateScreenForError(error: Throwable?) {
//        error?.let {
//            Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.find_movies_menu, menu)
//        val searchView = menu.findItem(R.id.menu_search)?.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextChange(text: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextSubmit(text: String?): Boolean {
//                findMoviesByName(text.orEmpty())
//                return false
//            }
//        })
//    }
//
//    private fun findMoviesByName(name: String?) {
//        findMoviesViewModel?.findMoviesByName(name)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.menu_search -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//}

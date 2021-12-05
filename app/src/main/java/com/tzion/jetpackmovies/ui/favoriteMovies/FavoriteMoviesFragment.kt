package com.tzion.jetpackmovies.ui.favoriteMovies

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Observer
//import androidx.paging.PagedList
//import androidx.recyclerview.widget.DefaultItemAnimator
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.tzion.jetpackmovies.databinding.FragmentFavoriteMoviesBinding
//import com.tzion.jetpackmovies.presentation.FavoriteMovieViewModel
//import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
//import dagger.hilt.android.AndroidEntryPoint
//import javax.inject.Inject
//
//@AndroidEntryPoint
//class FavoriteMoviesFragment : Fragment() {
//
//    @Inject
//    lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter
//    private val favoriteMoviesViewModel by viewModels<FavoriteMovieViewModel>()
//    lateinit var binding: FragmentFavoriteMoviesBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
//        setupFragment()
//        return binding.root
//    }
//
//    private fun setupFragment() {
//        setUpRecyclerView()
//        observeFavoriteMovieViewModel()
//    }
//
//    private fun setUpRecyclerView() {
//        binding.rvFavoriteMovies.addItemDecoration(
//            DividerItemDecoration(
//                context,
//                LinearLayoutManager.VERTICAL
//            )
//        )
//        binding.rvFavoriteMovies.itemAnimator = DefaultItemAnimator()
//        binding.rvFavoriteMovies.adapter = favoriteMoviesAdapter
//    }
//
//    private fun observeFavoriteMovieViewModel() {
//        favoriteMoviesViewModel
//            .favoriteMoviesLiveData()
//            .observe(viewLifecycleOwner, Observer { updateFavoriteMovieAdapter(it) })
//    }
//
//    private fun updateFavoriteMovieAdapter(movies: PagedList<UiFavoriteMovie>) {
//        favoriteMoviesAdapter.submitList(movies)
//    }
//}

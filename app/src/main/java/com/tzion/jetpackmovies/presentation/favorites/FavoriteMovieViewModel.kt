package com.tzion.jetpackmovies.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.entities.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    manageFavoriteMovie: ManageFavoriteMovie
) : ViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(DATABASE_PAGE_SIZE)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .build()

    private val favoriteMoviesLiveData: LiveData<PagedList<Movie.Favorite>> =
        LivePagedListBuilder(
            manageFavoriteMovie.favoriteMovies, config).build()

    fun favoriteMoviesLiveData(): LiveData<PagedList<Movie.Favorite>> = favoriteMoviesLiveData

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
        private const val INITIAL_LOAD_SIZE_HINT = 20
        private const val PREFETCH_DISTANCE = 10
    }
}

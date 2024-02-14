package com.tzion.jetpackmovies.presentation.favoritemovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.presentation.mapper.ViewFavoriteMovieMapper
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    manageFavoriteMovie: ManageFavoriteMovie,
    private val mapper: ViewFavoriteMovieMapper
) : ViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(DATABASE_PAGE_SIZE)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .build()

    private val favoriteMoviesLiveData: LiveData<PagedList<UiFavoriteMovie>> =
        LivePagedListBuilder(
            manageFavoriteMovie.favoriteMovies.mapByPage { favoriteMovies ->
                with(mapper) { favoriteMovies.map { it.toViewFavorite() } }
        }, config).build()

    fun favoriteMoviesLiveData(): LiveData<PagedList<UiFavoriteMovie>> = favoriteMoviesLiveData

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
        private const val INITIAL_LOAD_SIZE_HINT = 20
        private const val PREFETCH_DISTANCE = 10
    }
}
package com.tzion.jetpackmovies.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.presentation.mapper.UiFavoriteMovieMapper
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie

class FavoriteMovieViewModel @ViewModelInject constructor(
    manageFavoriteMoviesUseCase: ManageFavoriteMoviesUseCase,
    private val mapper: UiFavoriteMovieMapper
) : ViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(DATABASE_PAGE_SIZE)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .build()

    private val favoriteMoviesLiveData: LiveData<PagedList<UiFavoriteMovie>> =
        LivePagedListBuilder(
            manageFavoriteMoviesUseCase.getFavoriteMovies().mapByPage { favoriteMovies ->
                with(mapper) { favoriteMovies.map { it.fromDomainToUi() } }
        }, config).build()

    fun favoriteMoviesLiveData(): LiveData<PagedList<UiFavoriteMovie>> = favoriteMoviesLiveData

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
        private const val INITIAL_LOAD_SIZE_HINT = 20
        private const val PREFETCH_DISTANCE = 10
    }
}

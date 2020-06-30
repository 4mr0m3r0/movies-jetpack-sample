package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.google.gson.internal.bind.DateTypeAdapter
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.presentation.mapper.UiFavoriteMovieMapper
import com.tzion.jetpackmovies.presentation.model.UiFavoriteMovie
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import com.tzion.jetpackmovies.presentation.uistates.FavoriteMovieUiState
import javax.inject.Inject

class FavoriteMovieViewModel @Inject constructor(
    manageFavoriteMoviesUseCase: ManageFavoriteMoviesUseCase,
    private val mapper: UiFavoriteMovieMapper): ViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(DATABASE_PAGE_SIZE)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPrefetchDistance(PREFETCH_DISTANCE)
        .build()

    private val favoriteMoviesLiveData: LiveData<PagedList<UiFavoriteMovie>> =
        LivePagedListBuilder(manageFavoriteMoviesUseCase.getFavoriteMovies().mapByPage { favoriteMovies ->
            with(mapper) { favoriteMovies.map { it.fromDomainToUi() } }
        }, config).build()

    fun favoriteMoviesLiveData(): LiveData<PagedList<UiFavoriteMovie>> = favoriteMoviesLiveData

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
        private const val INITIAL_LOAD_SIZE_HINT = 20
        private const val PREFETCH_DISTANCE = 10
    }

}
package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.GetMovieDetailUseCase
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.presentation.mapper.UiFavoriteMovieMapper
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import com.tzion.jetpackmovies.presentation.model.UiMovieDetail
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val manageFavoriteMoviesUseCase: ManageFavoriteMoviesUseCase,
    private val mapper: UiMovieDetailMapper): ViewModel() {

    private val liveData: MutableLiveData<MovieDetailUiState> = MutableLiveData()

    fun getLiveData(): LiveData<MovieDetailUiState> = liveData

    fun loadMovieDetailById(movieId: String?) {
        viewModelScope.launch {
            try {
                liveData.value = MovieDetailUiState.Loading
                getMovieDetailUseCase
                    .getMovieDetailById(movieId)
                    .map { domainMovieDetail ->
                        with(mapper) { domainMovieDetail.fromDomainToUi() }
                    }
                    .collect { uiMovieDetail ->
                        liveData.value = MovieDetailUiState.Success(uiMovieDetail)
                    }
            } catch (e: Throwable) {
                liveData.postValue(MovieDetailUiState.Error(e))
            }
        }
    }

    fun addMovieToFavorites(movieId: String, movieDetail: UiMovieDetail) {
        viewModelScope.launch {
            manageFavoriteMoviesUseCase.saveFavoriteMovie(with(mapper) {
                movieDetail.fromUiMovieDetailToDomainFavoriteMovie(movieId)
            })
        }
    }

}
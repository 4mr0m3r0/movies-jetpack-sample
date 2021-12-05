package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.GetMovieDetailUseCase
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import com.tzion.jetpackmovies.presentation.model.MovieDetail
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val manageFavoriteMoviesUseCase: ManageFavoriteMoviesUseCase,
    private val mapper: UiMovieDetailMapper
) : ViewModel() {

    private val liveData: MutableLiveData<MovieDetailUiState> = MutableLiveData()

    fun getLiveData(): LiveData<MovieDetailUiState> = liveData

    fun loadMovieDetailById(movieId: String?) {
        viewModelScope.launch {
            liveData.value = MovieDetailUiState.LoadingUiState
            getMovieDetailUseCase
                .getMovieDetailById(movieId)
                .map { domainMovieDetail ->
                    with(mapper) { domainMovieDetail.fromDomainToUi() }
                }
                .catch { liveData.postValue(MovieDetailUiState.ErrorUiState) }
                .collect { uiMovieDetail ->
                    liveData.value = MovieDetailUiState.DetailDisplayUiState(uiMovieDetail)
                }
        }
    }

    fun addMovieToFavorites(movieId: String, movieDetail: MovieDetail) {
        viewModelScope.launch {
            manageFavoriteMoviesUseCase.saveFavoriteMovie(with(mapper) {
                movieDetail.fromUiMovieDetailToDomainFavoriteMovie(movieId)
            })
        }
    }
}

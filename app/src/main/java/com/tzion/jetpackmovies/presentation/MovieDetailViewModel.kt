package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.GetMovieDetailUseCase
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import com.tzion.jetpackmovies.presentation.model.MovieDetail
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val manageFavoriteMoviesUseCase: ManageFavoriteMoviesUseCase,
    private val mapper: UiMovieDetailMapper
) : ViewModel() {

    private val uiState: MutableStateFlow<MovieDetailUiState> =
        MutableStateFlow(MovieDetailUiState.Loading)

    fun uiState(): StateFlow<MovieDetailUiState> = uiState

    fun loadMovieDetailById(movieId: String?) {
        viewModelScope.launch {
            uiState.value = MovieDetailUiState.Loading
            getMovieDetailUseCase
                .getMovieDetailById(movieId)
                .map { domainMovieDetail ->
                    with(mapper) { domainMovieDetail.fromDomainToUi() }
                }
                .catch { uiState.value = MovieDetailUiState.Error }
                .collect { uiMovieDetail ->
                    uiState.value = MovieDetailUiState.Display(uiMovieDetail)
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

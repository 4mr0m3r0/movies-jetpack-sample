package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.FindMoviesByNameUseCase
import com.tzion.jetpackmovies.domain.exception.NoMoviesResultsException
import com.tzion.jetpackmovies.presentation.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.MoviesDisplayUiState
import com.tzion.jetpackmovies.presentation.uistates.MovieScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesViewModel @Inject constructor(
    private val findMoviesUseCase: FindMoviesByNameUseCase,
    private val mapper: UiMovieMapper
) : ViewModel() {

    private val uiState: MutableStateFlow<FindMoviesUiState> =
        MutableStateFlow(FindMoviesUiState.DefaultUiState)

    fun uiState(): StateFlow<FindMoviesUiState> = uiState

    fun findMoviesByName(name: String?) {
        viewModelScope.launch {
            uiState.update {
                MoviesDisplayUiState(
                    screenState = MovieScreenState(isLoading = true)
                )
            }
            findMoviesUseCase
                .findMovieByName(name)
                .map { domainMovies ->
                    with(mapper) { domainMovies.fromDomainToUi() }
                }
                .catch { cause ->
                    uiState.value = FindMoviesUiState.ErrorUiState(cause)
                }
                .collect { movies ->
                    if (movies.isEmpty()) {
                        uiState.value =
                            FindMoviesUiState.ErrorUiState(NoMoviesResultsException("No movies result"))
                    } else {
                        uiState.update {
                            (it as MoviesDisplayUiState).copy(
                                screenState = it.screenState.copy(
                                    isLoading = false,
                                    movies = movies
                                )
                            )
                        }
                    }
                }
        }
    }
}

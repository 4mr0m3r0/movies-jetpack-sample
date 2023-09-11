package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.FindMoviesByNameUseCase
import com.tzion.jetpackmovies.domain.exception.NoMoviesResultsException
import com.tzion.jetpackmovies.presentation.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
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
            uiState.value = FindMoviesUiState.LoadingUiSate
            findMoviesUseCase
                .findMovieByName(name)
                .map { domainMovies ->
                    with(mapper) { domainMovies.fromDomainToUi() }
                }
                .catch { cause ->
                    uiState.value = FindMoviesUiState.ErrorUiState(cause)
                }
                .collect { movies ->
                    if (movies.isNullOrEmpty()) {
                        uiState.value =
                            FindMoviesUiState.ErrorUiState(NoMoviesResultsException("No movies result"))
                    } else {
                        uiState.value = FindMoviesUiState.MoviesResultDisplayUiState(movies)
                    }
                }
        }
    }
}

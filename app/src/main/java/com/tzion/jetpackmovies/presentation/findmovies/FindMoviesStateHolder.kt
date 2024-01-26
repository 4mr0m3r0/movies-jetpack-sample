package com.tzion.jetpackmovies.presentation.findmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.domain.exception.NoMoviesResultsException
import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.presentation.findmovies.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState.MoviesDisplayUiState
import com.tzion.jetpackmovies.presentation.uistates.MovieScreenState
import com.tzion.jetpackmovies.presentation.userintent.UserIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesStateHolder @Inject constructor(
    private val findMoviesUseCase: FindMoviesByName,
    private val mapper: UiMovieMapper
) : ViewModel() {

    private val uiState: MutableStateFlow<FindMoviesUiState> = MutableStateFlow(FindMoviesUiState.DefaultUiState)
    private var job: Job? = null

    fun uiState(): StateFlow<FindMoviesUiState> = uiState
    private val movies: StateFlow<Result<List<DomainMovie>>> = findMoviesUseCase.moviesOutput.shareIn(
        initialValue = ,
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000)
    )

    fun processUserIntent(userIntent: UserIntent) {
        job?.cancel()
        job = viewModelScope.launch {

            userIntent.execute()
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

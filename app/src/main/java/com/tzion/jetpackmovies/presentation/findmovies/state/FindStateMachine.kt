package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface.ScreenState
import com.tzion.jetpackmovies.presentation.findmovies.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FindStateMachine @Inject constructor(
    private val mapper: UiMovieMapper,
    private val useCase: FindMoviesByName
) : FindStateContext() {
    var coroutineScope: CoroutineScope? = null
    val defaultScreenState = ScreenState()
    private val _screenState: MutableStateFlow<FindUserInterface> = MutableStateFlow(defaultScreenState)
    val screenState = _screenState.asStateFlow()

    override fun displayEmptyScreen() {
        _screenState.update { ScreenState(isEmptyScreen = true) }
    }
    override fun searchMovie() {
        _screenState.update { ScreenState(isLoading = true) }
        coroutineScope?.launch {
            useCase.findMovieByName(name = query).collect { domainMovies ->
                if (domainMovies.isEmpty()) {
                    noResults()
                } else {
                    successfulResults(
                        movies = with(mapper) { domainMovies.fromDomainToUi() }
                    )
                }
            }
        }
    }
    override fun displayNoResultsScreen() = runBlocking {
        _screenState.update { ScreenState(thereAreNoResults = true) }
    }
    override fun displayMovies(movies: List<Movie>) = runBlocking {
        _screenState.update { ScreenState(movies = movies) }
    }
    override fun displayErrorScreen(error: String?) = runBlocking {
        _screenState.update { ScreenState(errorMessage = error) }
    }
    override fun openMovieDetail() = runBlocking {
        _screenState.update { FindUserInterface.NavigateToDetail }
    }
}
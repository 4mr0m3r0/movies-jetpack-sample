package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.domain.model.DomainMovie
import com.tzion.jetpackmovies.presentation.findmovies.FindUserInterface
import com.tzion.jetpackmovies.presentation.findmovies.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class FindStateMachine(
    private val mapper: UiMovieMapper,
    private val coroutineScope: CoroutineScope
) : FindStateContext() {
    var userInterface: ((FindUserInterface) -> Unit)? = null
    private var moviesOutput: SharedFlow<List<DomainMovie>>? = null

    fun pressSearchButton(moviesOutput: SharedFlow<List<DomainMovie>>) {
        this.moviesOutput = moviesOutput
        super.pressSearchButton()
    }

    override fun displayEmptyScreen() {
        userInterface?.invoke(FindUserInterface.ScreenState(isEmptyScreen = true))
    }
    override fun searchMovie() {
        userInterface?.invoke(FindUserInterface.ScreenState(isLoading = true))
        coroutineScope.launch {
            moviesOutput?.collect { domainMovies ->
                if (domainMovies.isEmpty()) {
                    super.noResults()
                } else {
                    super.successfulResults(
                        movies = with(mapper) { domainMovies.fromDomainToUi() }
                    )
                }
            }
        }
    }
    override fun displayNoResultsScreen() {
        userInterface?.invoke(FindUserInterface.ScreenState(thereAreNoResults = true))
    }
    override fun displayMovies(movies: List<Movie>) {
        userInterface?.invoke(FindUserInterface.ScreenState(movies = movies))
    }
    override fun displayErrorScreen() {
        userInterface?.invoke(FindUserInterface.ScreenState(errorMessage = ""))
    }
    override fun openMovieDetail() {
        userInterface?.invoke(FindUserInterface.NavigateToDetail)
    }
}
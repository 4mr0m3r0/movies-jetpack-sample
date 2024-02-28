package com.tzion.jetpackmovies.presentation.search.state

import android.content.Context
import com.tzion.jetpackmovies.domain.FindMoviesByName
import com.tzion.jetpackmovies.presentation.mapper.ViewPosterMapper
import com.tzion.jetpackmovies.presentation.model.ViewPoster
import com.tzion.jetpackmovies.presentation.search.FindSideEffect
import com.tzion.jetpackmovies.presentation.search.FindSideEffect.NavigateToDetail
import com.tzion.jetpackmovies.presentation.search.FindUserInterface
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FindStateMachine @Inject constructor(
    private val mapper: ViewPosterMapper,
    private val useCase: FindMoviesByName,
    @ApplicationContext private val content: Context
) : FindStateContext(content = content) {
    var coroutineScope: CoroutineScope? = null
    val defaultScreenState = FindUserInterface.default()
    private val _screenState: MutableStateFlow<FindUserInterface> = MutableStateFlow(defaultScreenState)
    val screenState = _screenState.asStateFlow()
    private val _sideEffect: MutableSharedFlow<FindSideEffect> = MutableSharedFlow()
    val sideEffect = _sideEffect.asSharedFlow()

    override fun searchMovie() {
        _screenState.update { FindUserInterface(isLoading = true) }
        coroutineScope?.launch {
            useCase.find(name = query).collect { posters ->
                if (posters.isEmpty()) {
                    noResults()
                } else {
                    successfulResults(posters = with(mapper) { posters.toViewPoster() })
                }
            }
        }
    }
    override fun displayNoResultsScreen() = runBlocking {
        _screenState.update { FindUserInterface(thereAreNoResults = true) }
    }
    override fun displayMovies(posters: List<ViewPoster>) = runBlocking {
        _screenState.update { FindUserInterface(posters = posters) }
    }
    override fun displayErrorScreen(error: String?) = runBlocking {
        _screenState.update { FindUserInterface(errorMessage = error) }
    }
    override fun openMovieDetail(movieId: String) = runBlocking {
        _sideEffect.emit(NavigateToDetail(movieId = movieId))
    }
}
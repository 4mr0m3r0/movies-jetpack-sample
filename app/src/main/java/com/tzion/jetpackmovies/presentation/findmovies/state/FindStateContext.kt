package com.tzion.jetpackmovies.presentation.findmovies.state

import com.tzion.jetpackmovies.presentation.model.Movie

/** Init
 *********************************************
 **  start Empty-Screen displayEmptyScreen  **
 *********************************************
 */
/** Empty-Screen
 *****************************************************
 **  pressSearchButton Searching-Movies searchMovie **
 *****************************************************
 */
/** Searching-Movies
 ************************************************************
 **  noResults Notifying-No-Results displayNoResultsScreen **
 **  successfulResults Listing-Movies displayMovies        **
 **  searchFailed Notifying-Error displayErrorScreen       **
 ************************************************************
 */
/** Notifying-Error
 ****************************************************
 ** pressSearchButton Searching-Movies searchMovie **
 ****************************************************
 */
/** Listing-Movies
 *****************************************************
 ** pressSearchButton Searching-Movies searchMovie  **
 ** selectMovie Opened-Detail openMovieDetail       **
 *****************************************************
 */
/** Notifying-No-Results
 ****************************************************
 ** pressSearchButton Searching-Movies searchMovie **
 ****************************************************
 */
open class FindStateContext : FindStateMachineActions {
    private val initState: FindState = FindInit.getInstance()
    private var state = initState
    protected var query: String? = null
        private set

    fun start() {
        state.start(this)
    }
    fun pressSearchButton(query: String?) {
        this.query = query
        state.pressSearchButton(this)
    }
    fun noResults() {
        state.noResults(this)
    }
    fun successfulResults(movies: List<Movie>) {
        state.successfulResults(context = this, movies = movies)
    }
    fun searchFailed(error: String?) {
        state.searchFailed(context = this, error = error)
    }
    fun tapMovie() {
        state.selectMovie(this)
    }
    fun changeState(state: FindState) {
        this.state = state
    }
}
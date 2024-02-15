package com.tzion.jetpackmovies.presentation.findmovies.state

import android.content.Context
import com.tzion.jetpackmovies.presentation.model.ViewPoster

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
open class FindStateContext(private val content: Context) : FindStateMachineActions {
    private val initState: FindState = FindEmptyScreen.getInstance()
    private var state = initState
    protected var query: String? = null
        private set

    fun pressSearchButton(query: String?) {
        this.query = query
        state.pressSearchButton(this)
    }
    fun noResults() {
        state.noResults(this)
    }
    fun successfulResults(posters: List<ViewPoster>) {
        state.successfulResults(context = this, posters = posters)
    }
    fun searchFailed(error: String?) {
        state.searchFailed(context = this, error = error)
    }
    fun tapMovie(movieId: String?) {
        state.selectMovie(context = this, movieId = movieId, content = content)
    }
    fun changeState(state: FindState) {
        this.state = state
    }
}
package com.tzion.jetpackmovies.presentation.findmovies.state

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
class FindContext {
    private val initState: FindState = FindInit.getInstance()
    private var state = initState

    fun start() {
        state.start(this)
    }
    fun pressSearchButton() {
        state.pressSearchButton(this)
    }
    fun noResults() {
        state.noResults(this)
    }
    fun successfulResults() {
        state.successfulResults(this)
    }
    fun searchFailed() {
        state.searchFailed(this)
    }
    fun selectMovie() {
        state.selectMovie(this)
    }
    fun changeState(state: FindState) {
        this.state = state
    }
    fun displayEmptyScreen() {
        //TODO: Perhaps this emits a flow?
    }
    fun searchMovie() {
        //TODO: Perhaps this emits a flow?
    }
    fun displayNoResultsScreen() {
        //TODO: Perhaps this emits a flow?
    }
    fun displayMovies() {
        //TODO: Perhaps this emits a flow?
    }
    fun displayErrorScreen() {
        //TODO: Perhaps this emits a flow?
    }
    fun openMovieDetail() {
        //TODO: Perhaps this emits a flow?
    }
}
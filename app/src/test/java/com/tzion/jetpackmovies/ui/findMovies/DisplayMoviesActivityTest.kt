package com.tzion.jetpackmovies.ui.findMovies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tzion.jetpackmovies.JetpackMoviesApp
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.factory.MoviesFactory
import com.tzion.jetpackmovies.presentation.model.UiMovie
import com.tzion.jetpackmovies.test.RecyclerViewMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayMoviesActivityTest {

//    @get:Rule
//    val rule = ActivityTestRule(DisplayMoviesActivity::class.java)

    private val applicationContext = getApplicationContext<JetpackMoviesApp>()
    private lateinit var scenario: ActivityScenario<FindMoviesByNameActivity>

    @Before
    fun setUp() {
        scenario = launch(FindMoviesByNameActivity::class.java)
    }

    @Test
    fun whenActivityLaunch_thenShouldDisplaySearchImage() {
        onView(withId(R.id.aciv_search_display_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun whenActivityLaunch_thenShouldDisplaySearchText() {
        onView(withId(R.id.tv_instructions)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun whenActivityLunch_thenShouldShowMakeASearchText() {
        onView(
            withId(R.id.tv_instructions)
        ).check(
            matches(withText(applicationContext.getString(R.string.make_a_search)))
        )
    }

    @Test
    fun whenActivityLunch_menuSearchShouldBeVisible() {
        onView(withId(R.id.menu_search)).check(matches(isDisplayed()))
    }

    @Test
    fun givenAListOfMovies_whenSetScreenForSuccess_thenShouldDisplayTheList() {
        val moviesView = MoviesFactory.makeMovieViewList(10)
        scenario.onActivity { activity ->
//            activity.setScreenForSuccess(moviesView)
        }

        checkMoviesAreDisplayed(moviesView)
    }

    @Test
    fun givenAListOfMovies_whenRecreateActivity_thenShouldDisplayTheList() {
        val moviesView = MoviesFactory.makeMovieViewList(10)
        scenario.onActivity { activity ->
//            activity.setScreenForSuccess(moviesView)
        }

        scenario.recreate()

        checkMoviesAreDisplayed(moviesView)
    }

    @Test
    fun whenRecreateActivity_thenShouldDisplaySearchImage() {

        scenario.recreate()

        onView(withId(R.id.aciv_search_display_movies)).check(matches(isDisplayed()))
    }

    private fun checkMoviesAreDisplayed(movies: List<UiMovie>) {
        movies.forEachIndexed { index, movie ->
            onView(withId(R.id.rv_display_movies)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index)
            )
            onView(RecyclerViewMatcher.withRecyclerView(R.id.rv_display_movies).atPosition(index)).check(
                matches(hasDescendant(withText(movie.title)))
            )
        }
    }
}

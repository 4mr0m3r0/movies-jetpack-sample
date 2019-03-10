package com.tzion.openmoviesdatabase.movie.displayMovies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import com.tzion.domain.movie.model.Movie
import com.tzion.openmoviesdatabase.OpenMoviesDatabaseApp
import com.tzion.openmoviesdatabase.R
import com.tzion.openmoviesdatabase.di.DaggerTestApplicationComponent
import com.tzion.openmoviesdatabase.movie.factory.MoviesFactory
import com.tzion.openmoviesdatabase.movie.model.MovieView
import com.tzion.openmoviesdatabase.test.RecyclerViewMatcher
import com.tzion.openmoviesdatabase.test.TestApplication
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayMoviesActivityTest {

    @get:Rule
    val rule = ActivityTestRule(DisplayMoviesActivity::class.java)

    private val applicationContext = getApplicationContext<OpenMoviesDatabaseApp>()
//    private lateinit var scenario: ActivityScenario<DisplayMoviesActivity>

    @Before
    fun setUp() {
//        scenario = launch(DisplayMoviesActivity::class.java)
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
        onView(withId(R.id.tv_instructions)).check(matches(withText(applicationContext.getString(R.string.make_a_search))))
    }

    @Test
    fun whenActivityLunch_menuSearchShouldBeVisible() {
        onView(withId(R.id.menu_search)).check(matches(isDisplayed()))
    }

    @Test
    fun givenAListOfMovies_whenSetScreenForSuccess_thenShouldDisplayTheList() {
        val moviesView = MoviesFactory.makeMovieViewList(10)

        rule.activity.setScreenForSuccess(moviesView)

        checkMoviesAreDisplayed(moviesView)
    }

    private fun checkMoviesAreDisplayed(movies: List<MovieView>) {
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
package com.tzion.jetpackmovies.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.tzion.jetpackmovies.R
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun defaultFindAMovieTextShouldBeDisplayed() {
        onView(allOf(withId(R.id.tv_instructions), withText("Find a movie")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun defaultFindAMovieImageShouldBeDisplayed() {
        onView(withId(R.id.aciv_search_display_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun verifyDrawerNavigationOpen() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        Thread.sleep(2000)
        onView(withId(R.id.findMoviesByNameFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.favoriteMoviesFragment)).check(matches(isDisplayed()))
    }

}
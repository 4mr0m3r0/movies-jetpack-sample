package com.tzion.jetpackmovies.presentation.favorites.composable

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import com.tzion.jetpackmovies.random.FavoriteMovieRandom.listOfFavoriteMovie
import org.junit.Rule
import org.junit.Test

class FavoriteDisplayTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun givenEmptyList_whenDisplay_thenCountZero() {
        rule.setContent {
            FavoriteDisplay(movies = emptyList())
        }

        rule.onNodeWithTag("FavColumn").onChildren().assertCountEquals(0)
    }

    @Test
    fun givenListOf5Movies_whenDisplay_thenCount5Items() {
        val count = 5
        val favoriteMovies = listOfFavoriteMovie(count)

        rule.setContent {
            FavoriteDisplay(movies = favoriteMovies)
        }

        rule.onNodeWithTag("FavColumn").onChildren().assertCountEquals(5)
    }

    //TODO: Next
    @Test
    fun testingItemsInside() {
//        rule.onNodeWithTag("FavColumn")
//            .onChildren()
//            .onFirst()
//            .assert(
//                hasText(favoriteMovies.first().title)
//            )

//        rule.onNodeWithTag("FavColumn")
//            .performScrollToNode(
//                hasText(
//                    favoriteMovies[1].title
//                )
//            )
    }
}
package com.tzion.jetpackmovies.presentation.search.composable

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class DefaultEmptyTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun enterScreen_showsEmptyStateScreen() {
        rule.setContent { DefaultDisplay() }
        rule.onNodeWithContentDescription("Empty list").assertExists()
    }
}
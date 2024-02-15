package com.tzion.jetpackmovies.presentation.findmovies.composable

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.tzion.jetpackmovies.RandomData
import org.junit.Rule
import org.junit.Test

class ErrorMessageTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun givenErrorMessage_whenComposable_thenDisplayMessage() {
        val errorMessage = RandomData.generateString()

        rule.setContent { ErrorMessage(errorMessage) }

        rule.onNodeWithText(errorMessage).assertExists()
    }

    @Test
    fun givenNoMessage_whenComposable_thenDefaultMsg() {

        rule.setContent { ErrorMessage() }

        rule.onNodeWithText("Something went wrong").assertExists()
    }
}
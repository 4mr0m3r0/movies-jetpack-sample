package com.tzion.jetpackmovies.presentation.moviedetail.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tzion.jetpackmovies.presentation.moviedetail.DetailUserInterface
import com.tzion.jetpackmovies.uicomponent.template.MovieDetailTemplate

@Composable
fun DetailDisplay(
    userInterface: DetailUserInterface,
    paddingValues: PaddingValues
) {
    if (userInterface.attributes == null) {
        println(">>> Attributes are null")
        println(">>> ${userInterface.errorMessage}")
    } else {
        MovieDetailTemplate(
            attributes = userInterface.attributes,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
        )
    }
}

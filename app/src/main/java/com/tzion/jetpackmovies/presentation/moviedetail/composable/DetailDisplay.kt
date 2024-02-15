package com.tzion.jetpackmovies.presentation.moviedetail.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tzion.jetpackmovies.presentation.moviedetail.DetailUserInterface
import com.tzion.jetpackmovies.uicomponent.template.DetailTemplate
import com.tzion.jetpackmovies.uicomponent.template.LoadingTemplate

@Composable
fun DetailDisplay(
    userInterface: DetailUserInterface,
    paddingValues: PaddingValues
) {
    when {
        userInterface.isLoading -> LoadingTemplate()
        userInterface.attributes != null -> DetailTemplate(
            attributes = userInterface.attributes,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
        )
        userInterface.errorMessage != null -> println("Error: ${userInterface.errorMessage}")
    }
}

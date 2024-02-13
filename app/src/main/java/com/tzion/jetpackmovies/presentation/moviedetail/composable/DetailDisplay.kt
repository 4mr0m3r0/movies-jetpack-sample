package com.tzion.jetpackmovies.presentation.moviedetail.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate
import com.tzion.jetpackmovies.uicomponent.template.MovieDetailTemplate

@Composable
fun DetailDisplay(
    attributes: AttrsDetailTemplate,
    paddingValues: PaddingValues
) {
    MovieDetailTemplate(
        attributes = attributes,
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
    )
}

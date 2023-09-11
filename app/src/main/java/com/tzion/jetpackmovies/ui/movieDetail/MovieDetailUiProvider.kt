package com.tzion.jetpackmovies.ui.movieDetail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate
import com.tzion.jetpackmovies.uicomponent.template.DetailTemplate

@Composable
fun Loading() {
    val progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(progress = animatedProgress)
    }
}

@Composable
fun DetailDisplay(attributes: AttrsDetailTemplate) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        DetailTemplate(attributes = attributes)
    }
}

@Composable
fun ErrorMessage() {
    Snackbar(
        modifier = Modifier.padding(dimensionResource(R.dimen.snackbar_padding))
    ) {
        Text(text = stringResource(R.string.something_went_wrong))
    }
}

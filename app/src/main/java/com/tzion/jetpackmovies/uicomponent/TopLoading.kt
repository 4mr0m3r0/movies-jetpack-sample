package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TopLoading() {
    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
}
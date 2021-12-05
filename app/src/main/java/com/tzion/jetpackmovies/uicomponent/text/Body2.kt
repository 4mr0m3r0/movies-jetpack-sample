package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Body2(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        style = MaterialTheme.typography.body2,
        modifier = modifier
    )
}

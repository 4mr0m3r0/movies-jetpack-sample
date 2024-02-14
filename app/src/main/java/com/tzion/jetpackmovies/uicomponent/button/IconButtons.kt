package com.tzion.jetpackmovies.uicomponent.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable

@Composable
fun ArrowBack(
    onClick: () -> Unit = {},
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    contentDescription: String? = null,
) {
    IconButton(
        onClick = onClick,
        colors = colors
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun Favorite(
    onClick: () -> Unit = {},
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    contentDescription: String? = null,
) {
    IconButton(
        onClick = onClick,
        colors = colors
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = contentDescription
        )
    }
}
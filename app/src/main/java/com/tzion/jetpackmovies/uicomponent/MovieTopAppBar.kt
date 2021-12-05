package com.tzion.jetpackmovies.uicomponent

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R

@Composable
fun MovieTopAppBar(contentText: String, onBackClick: () -> Unit) {
    TopAppBar(
        elevation = dimensionResource(R.dimen.top_app_bar_elevation),
        title = {
            Text(contentText)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, stringResource(R.string.go_back))
            }
        }
    )
}
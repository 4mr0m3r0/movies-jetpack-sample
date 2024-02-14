package com.tzion.jetpackmovies.uicomponent.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.button.ArrowBack
import com.tzion.jetpackmovies.uicomponent.button.Favorite
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@ExperimentalMaterial3Api
@Composable
fun TransparentTopAppBar(
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = { },
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            scrolledContainerColor = Color.Transparent,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.Transparent,
            actionIconContentColor = Color.White
        ),
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Light")
@Composable
private fun Light() {
    MoviesTheme {
        Surface(color = Color.Red) {
            TransparentTopAppBar(
                navigationIcon = { ArrowBack() },
                actions = { Favorite() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Dark")
@Composable
private fun Dark() {
    MoviesTheme(darkTheme = true) {
        Surface(color = Color.Red) {
            TransparentTopAppBar(
                navigationIcon = { ArrowBack() },
                actions = { Favorite() }
            )
        }
    }
}
package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(
    contentText: String,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(contentText)
        },
        navigationIcon = navigationIcon,
        actions = actions
    )
}

@Preview("MovieTopAppBar Light")
@Composable
fun PreviewMovieTopAppBarLight() {
    MoviesTheme {
        Surface {
            MovieTopAppBar(
                contentText = "Find a Movie",
                navigationIcon = {},
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(R.string.find_a_movie)
                        )
                    }
                }
            )
        }
    }
}

@Preview("MovieTopAppBar Dark")
@Composable
fun PreviewMovieTopAppBarDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            MovieTopAppBar(
                contentText = "Find a Movie",
                navigationIcon = {},
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(R.string.find_a_movie)
                        )
                    }
                }
            )
        }
    }
}

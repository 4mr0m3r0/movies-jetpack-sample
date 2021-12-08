package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun MovieTopAppBar(
    contentText: String,
    navigationEvent: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        elevation = dimensionResource(R.dimen.top_app_bar_elevation),
        title = {
            Text(contentText)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = navigationEvent) {
                Icon(Icons.Filled.ArrowBack, stringResource(R.string.go_back))
            }
        },
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
                navigationEvent = {},
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
                navigationEvent = {},
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

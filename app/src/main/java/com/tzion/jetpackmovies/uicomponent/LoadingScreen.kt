package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun LoadingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopLoading()
    }
}

@Preview("LoadingScreen Light")
@Composable
fun PreviewLoadingScreenLight() {
    MoviesTheme {
        Surface {
            LoadingScreen()
        }
    }
}

@Preview("LoadingScreen Dark")
@Composable
fun PreviewLoadingScreenDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            LoadingScreen()
        }
    }
}
package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun Subtitle1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle1,
        modifier = modifier
    )
}

@Preview("Subtitle1 Light")
@Composable
fun PreviewSubtitle1Light() {
    MoviesTheme {
        Surface {
            Subtitle2("Subtitle1")
        }
    }
}

@Preview("Subtitle1 Dark")
@Composable
fun PreviewSubtitle1Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Subtitle2("Subtitle1")
        }
    }
}
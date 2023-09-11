package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun Subtitle2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        modifier = modifier
    )
}

@Preview("Subtitle2 Light")
@Composable
fun PreviewSubtitle2Light() {
    MoviesTheme {
        Surface {
            Subtitle2("Subtitle2")
        }
    }
}

@Preview("Subtitle2 Dark")
@Composable
fun PreviewSubtitle2Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Subtitle2("Subtitle2")
        }
    }
}
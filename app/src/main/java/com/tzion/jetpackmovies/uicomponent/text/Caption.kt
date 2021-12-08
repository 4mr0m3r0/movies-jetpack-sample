package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun Caption(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        modifier = modifier
    )
}

@Preview("Caption Light")
@Composable
fun PreviewCaptionLight() {
    MoviesTheme {
        Surface {
            Caption("Caption")
        }
    }
}

@Preview("Caption Dark")
@Composable
fun PreviewCaptionDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Caption("Caption")
        }
    }
}
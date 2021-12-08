package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun Body2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        modifier = modifier
    )
}

@Preview("Body2 Light")
@Composable
fun PreviewBody2Light() {
    MoviesTheme {
        Surface {
            Body2("Body2")
        }
    }
}

@Preview("Body2 Dark")
@Composable
fun PreviewBody2Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Body2("Body2")
        }
    }
}
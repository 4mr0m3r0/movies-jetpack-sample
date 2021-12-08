package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun HeadlineH5(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        modifier = modifier
    )
}

@Preview("HeadlineH5 Light")
@Composable
fun PreviewHeadlineH5Light() {
    MoviesTheme {
        Surface {
            HeadlineH5("HeadlineH5")
        }
    }
}

@Preview("HeadlineH5 Dark")
@Composable
fun PreviewHeadlineH5Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            HeadlineH5("HeadlineH5")
        }
    }
}

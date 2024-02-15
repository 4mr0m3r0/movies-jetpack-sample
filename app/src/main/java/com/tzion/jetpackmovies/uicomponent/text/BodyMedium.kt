package com.tzion.jetpackmovies.uicomponent.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun BodyMedium(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Preview("Light")
@Composable
private fun PreviewLight() {
    MoviesTheme {
        Surface {
            BodyMedium("Body Large")
        }
    }
}

@Preview("Dark")
@Composable
private fun PreviewDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            BodyMedium("Body Medium")
        }
    }
}
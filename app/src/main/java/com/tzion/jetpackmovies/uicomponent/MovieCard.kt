package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun MovieCard(
    headline: String,
    supportingText: String,
    modifier: Modifier = Modifier,
    contentDescription: String?,
    image: Any?
) {
    Card(modifier = modifier) {
        if (image == null) {
            Image(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        } else {
            GlideImage(
                imageModel = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Text(
            text = headline,
            modifier = Modifier.padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp
            ),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = supportingText,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview("Light")
@Composable
private fun PreviewMovieCardLight() {
    MoviesTheme {
        Surface {
            MovieCard(
                headline = "Headline",
                supportingText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                contentDescription = null,
                image = null
            )
        }
    }
}

@Preview("Dark")
@Composable
private fun PreviewMovieCardDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            MovieCard(
                headline = "Headline",
                supportingText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                contentDescription = null,
                image = null
            )
        }
    }
}
package com.tzion.jetpackmovies.uicomponent.template

import android.content.Context
import androidx.annotation.IdRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.text.Body2
import com.tzion.jetpackmovies.uicomponent.text.HeadlineH5
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme
import com.tzion.jetpackmovies.uicomponent.theme.RatingStar

@Composable
fun MovieDetailTemplate(
    attributes: AttrsDetailTemplate,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        if (attributes.poster.isNotEmpty()) {
            GlideImage(
                imageModel = attributes.poster
            )
        }
        HeadlineH5(text = attributes.title)
        Row {
            Body2(text = attributes.released)
            Body2(
                text = attributes.runtime,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier.width(18.dp),
                tint = RatingStar
            )
            Body2(
                text = "${attributes.rating}/10",
                modifier = Modifier.padding(start = 2.dp)
            )
            Body2(
                text = attributes.votes,
                modifier = Modifier.padding(start = 24.dp)
            )
            attributes.tomatoMeterPainter?.let { id ->
                Image(
                    painter = painterResource(id = id),
                    contentDescription = attributes.tomatoMeterContentDesc,
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .width(18.dp)
                )
            }
        }
        Body2(text = attributes.plot)
        Body2(text = attributes.genre)
        Body2(text = attributes.actors)
        Body2(text = attributes.writer)
        Body2(text = attributes.director)
        Body2(text = attributes.language)
        Body2(text = attributes.country)
    }
}

data class AttrsDetailTemplate(
    val poster: String = "",
    val title: String = "",
    val runtime: String = "",
    val released: String = "",
    val rating: String = "",
    val votes: String = "",
    val plot: String = "",
    val genre: String = "",
    val actors: String = "",
    val writer: String = "",
    val director: String = "",
    val language: String = "",
    val country: String = "",
    @IdRes val tomatoMeterPainter: Int? = null,
    val tomatoMeterContentDesc: String? = null,
)

@Preview("DetailTemplate Light")
@Composable
fun PreviewDetailTemplateLight() {
    val context = LocalContext.current
    MoviesTheme {
        Surface {
            MovieDetailTemplate(
                attributes = buildAttrsDetailTemplate(context)
            )
        }
    }
}

@Preview("DetailTemplate Dark")
@Composable
fun PreviewDetailTemplateDark() {
    val context = LocalContext.current
    MoviesTheme {
        Surface {
            MovieDetailTemplate(
                attributes = buildAttrsDetailTemplate(context)
            )
        }
    }
}

private fun buildAttrsDetailTemplate(context: Context) = AttrsDetailTemplate(
    title = "The Equalizer 3",
    released = "Released: 2023",
    runtime = "Runtime: 1h 49m",
    rating = "6.9",
    votes = "${context.getString(R.string.votes)}: 71,289",
    plot = context.getString(R.string.plot),
    genre = context.getString(R.string.genre),
    actors = context.getString(R.string.actors),
    writer = context.getString(R.string.writer),
    director = context.getString(R.string.director),
    language = context.getString(R.string.language),
    country = context.getString(R.string.country),
)

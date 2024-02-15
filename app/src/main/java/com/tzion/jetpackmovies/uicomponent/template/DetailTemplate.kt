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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.text.BodyMedium
import com.tzion.jetpackmovies.uicomponent.text.HeadlineLarge
import com.tzion.jetpackmovies.uicomponent.text.TitleMedium
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme
import com.tzion.jetpackmovies.uicomponent.theme.PaddingDefaults.HorizontalTemplateContent
import com.tzion.jetpackmovies.uicomponent.theme.PaddingDefaults.VerticalTemplateContent
import com.tzion.jetpackmovies.uicomponent.theme.RatingStar

@Composable
fun DetailTemplate(
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
        Column(
            modifier = Modifier.padding(
                horizontal = HorizontalTemplateContent,
                vertical = VerticalTemplateContent
            )
        ) {
            HeadlineLarge(text = attributes.title)
            Row {
                BodyMedium(text = attributes.released)
                BodyMedium(
                    text = attributes.runtime,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                if (attributes.rating.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        modifier.width(18.dp),
                        tint = RatingStar
                    )
                    BodyMedium(
                        text = attributes.rating,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
                BodyMedium(
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
            if (attributes.genre.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.genre)}: ",
                    content = attributes.genre
                )
            }
            if (attributes.actors.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.cast)}: ",
                    content = attributes.actors
                )
            }
            if (attributes.writer.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.writer)}: ",
                    content = attributes.writer
                )
            }
            if (attributes.director.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.director)}: ",
                    content = attributes.director
                )
            }
            if (attributes.language.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.language)}: ",
                    content = attributes.language
                )
            }
            if (attributes.country.isNotEmpty()) {
                Specifications(
                    title = "${stringResource(id = R.string.country)}: ",
                    content = attributes.country
                )
            }
            BodyMedium(
                modifier = Modifier.padding(top = 5.dp),
                text = attributes.plot
            )
        }
    }
}

@Composable
private fun Specifications(title: String, content: String) {
    Row(modifier = Modifier.padding(vertical = 2.dp)) {
        TitleMedium(text = title)
        BodyMedium(text = content)
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
            DetailTemplate(
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
            DetailTemplate(
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
    genre = "Drama, Comedy",
    actors = context.getString(R.string.actors),
    writer = context.getString(R.string.writer),
    director = context.getString(R.string.director),
    language = context.getString(R.string.language),
    country = context.getString(R.string.country),
)

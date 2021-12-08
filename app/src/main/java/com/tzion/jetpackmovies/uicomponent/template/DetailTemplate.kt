package com.tzion.jetpackmovies.uicomponent.template

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.text.Body2
import com.tzion.jetpackmovies.uicomponent.text.HeadlineH5
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

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
    val country: String = ""
)

@Composable
fun DetailTemplate(
    attributes: AttrsDetailTemplate,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        GlideImage(
            imageModel = attributes.poster
        )
        HeadlineH5(text = attributes.title)
        Row {
            Body2(text = attributes.runtime)
            Body2(text = attributes.released)
        }
        Row {
            Body2(text = attributes.rating)
            Body2(text = attributes.votes)
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
    title = "Demo Title",
    runtime = context.getString(R.string.runtime),
    released = context.getString(R.string.released),
    rating = context.getString(R.string.rating),
    votes = context.getString(R.string.votes),
    plot = context.getString(R.string.plot),
    genre = context.getString(R.string.genre),
    actors = context.getString(R.string.actors),
    writer = context.getString(R.string.writer),
    director = context.getString(R.string.director),
    language = context.getString(R.string.language),
    country = context.getString(R.string.country),
)

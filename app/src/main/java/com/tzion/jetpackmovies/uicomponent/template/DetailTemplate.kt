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
import com.tzion.jetpackmovies.ui.theme.MoviesTheme
import com.tzion.jetpackmovies.uicomponent.text.Body2
import com.tzion.jetpackmovies.uicomponent.text.HeadlineH5

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
        HeadlineH5(content = attributes.title)
        Row {
            Body2(content = attributes.runtime)
            Body2(content = attributes.released)
        }
        Row {
            Body2(content = attributes.rating)
            Body2(content = attributes.votes)
        }
        Body2(content = attributes.plot)
        Body2(content = attributes.genre)
        Body2(content = attributes.actors)
        Body2(content = attributes.writer)
        Body2(content = attributes.director)
        Body2(content = attributes.language)
        Body2(content = attributes.country)
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

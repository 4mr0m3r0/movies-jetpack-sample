package com.tzion.jetpackmovies.uicomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.text.Body2
import com.tzion.jetpackmovies.uicomponent.text.Subtitle1
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun ListElementRow(
    title: String,
    subtitle: String,
    extra: String,
    image: Any? = null
) {
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.listing_row_padding))
            .fillMaxWidth()
    ) {
        if (image == null) {
            Image(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = "",
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.listing_image_width))
            )
        } else {
            GlideImage(
                imageModel = image,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(dimensionResource(id = R.dimen.listing_image_width))
            )
        }
        Column {
            Subtitle1(text = title)
            Body2(text = subtitle)
            Body2(text = extra)
        }
    }
}

@Preview("ListElementRow Light")
@Composable
fun PreviewListElementRowLight() {
    MoviesTheme {
        Surface {
            ListElementRow(
                title = "Any title",
                subtitle = "Subtitle",
                extra = "Extra info"
            )
        }
    }
}

@Preview("ListElementRow Dark")
@Composable
fun PreviewListElementRowDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            ListElementRow(
                title = "Any title",
                subtitle = "Subtitle",
                extra = "Extra info"
            )
        }
    }
}
package com.tzion.jetpackmovies.uicomponent.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.text.Body2
import com.tzion.jetpackmovies.uicomponent.text.Subtitle1
import com.tzion.jetpackmovies.uicomponent.theme.MoviesTheme

@Composable
fun ListItemRow(
    title: String,
    subtitle: String,
    extra: String,
    image: String?,
    contentDescription: String? = null
) {
    ListItem(
        headlineContent = { Subtitle1(text = title) },
        supportingContent = { Body2(text = "$subtitle - $extra")  },
        leadingContent = {
            ImageSection(image = image, contentDescription = contentDescription)
        }
    )
}

@Composable
private fun ImageSection(image: String?, contentDescription: String?) {
    if (image.isNullOrEmpty()) {
        DefaultImage(contentDescription)
    } else {
        GlideImage(
            imageModel = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            },
            failure = {
                DefaultImage(contentDescription)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
}

@Composable
private fun DefaultImage(contentDescription: String?) {
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
    )
}

@Preview("ListElementRow Light")
@Composable
fun PreviewListElementRowLight() {
    MoviesTheme {
        Surface {
            ListItemRow(
                title = "Any title",
                subtitle = "Subtitle",
                extra = "Extra info",
                image = null
            )
        }
    }
}

@Preview("ListElementRow Dark")
@Composable
fun PreviewListElementRowDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            ListItemRow(
                title = "Any title",
                subtitle = "Subtitle",
                extra = "Extra info",
                image = null
            )
        }
    }
}
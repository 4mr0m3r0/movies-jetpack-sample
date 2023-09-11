package com.tzion.jetpackmovies.ui.findMovies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.model.Movie
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.TopLoading
import com.tzion.jetpackmovies.uicomponent.TopSearchTextField

@Composable
fun DefaultScreenDisplay() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_search_gray_96dp),
            contentDescription = stringResource(id = R.string.empty_list)
        )
    }
}

@Composable
fun MoviesResultDisplay(
    isLoading: Boolean = false,
    movies: List<Movie> = emptyList()
) {
    if (isLoading) {
        TopLoading()
    }
    LazyColumn {
        items(movies) { movie ->
            MovieElementRow(movie)
        }
    }
}

@Composable
private fun MovieElementRow(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        GlideImage(
            imageModel = movie.poster,
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(dimensionResource(id = R.dimen.listing_image_width))
        )
        Column {
            Text(text = movie.title)
            Text(text = movie.year)
            Text(text = movie.type)
        }
    }
}

@Composable
fun ErrorMessage(message: String?) {
    Snackbar(
        modifier = Modifier.padding(dimensionResource(R.dimen.snackbar_padding))
    ) {
        Text(text = message ?: stringResource(R.string.something_went_wrong))
    }
}

@Composable
fun FindMovieTopAppBar(
    contentText: String,
    navigationIcon: @Composable () -> Unit = {},
    onSearchEvent: (String) -> Unit = {}
) {
    val topAppBarVisible = remember { mutableStateOf(true) }
    val searchBarVisible = remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = topAppBarVisible.value,
        enter = expandHorizontally(expandFrom = Alignment.Start) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
    ) {
        MovieTopAppBar(
            contentText = contentText,
            navigationIcon = navigationIcon,
            actions = {
                IconButton(onClick = {
                    topAppBarVisible.value = false
                    searchBarVisible.value = true
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.find_a_movie)
                    )
                }
            }
        )
    }
    AnimatedVisibility(
        visible = searchBarVisible.value,
        enter = expandHorizontally(expandFrom = Alignment.Start) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
    ) {
        var searchText by rememberSaveable { mutableStateOf("") }
        TopSearchTextField(
            searchText = searchText,
            onSearchChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = "${stringResource(id = R.string.type_a_name)}...",
            searchIconContentDescription = stringResource(R.string.find_a_movie),
            onSearchEvent = {
                topAppBarVisible.value = true
                searchBarVisible.value = false
                onSearchEvent(searchText)
            }
        )
    }
}

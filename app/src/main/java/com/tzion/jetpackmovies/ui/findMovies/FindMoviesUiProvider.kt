package com.tzion.jetpackmovies.ui.findMovies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.primarySurface
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
import androidx.compose.ui.text.input.ImeAction
import com.skydoves.landscapist.glide.GlideImage
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.model.Movie

@Composable
fun Loading() {
    val progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(progress = animatedProgress)
    }
}

@Composable
fun MoviesResultDisplay(movies: List<Movie>) {
    if (movies.isNotEmpty()) {
        LazyColumn {
            items(movies) { movie ->
                MovieElementRow(movie)
            }
        }
    } else {
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
}

@Composable
private fun MovieElementRow(movie: Movie) {
    Row(
        modifier = Modifier.fillMaxWidth()
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
    onBackEvent: () -> Unit,
    onSearchEvent: (String) -> Unit = {}
) {
    val topAppBarVisible = remember { mutableStateOf(true) }
    val searchBarVisible = remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = topAppBarVisible.value,
        enter = expandHorizontally(expandFrom = Alignment.Start) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
    ) {
        TopAppBar(
            elevation = dimensionResource(R.dimen.top_app_bar_elevation),
            title = {
                Text(contentText)
            },
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = onBackEvent) {
                    Icon(Icons.Filled.ArrowBack, stringResource(R.string.go_back))
                }
            },
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
        TextField(
            value = searchText,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { searchText = it },
            placeholder = { Text("Type a name...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(R.string.find_a_movie)
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    topAppBarVisible.value = true
                    searchBarVisible.value = false
                    onSearchEvent(searchText)
                }
            )
        )
    }
}

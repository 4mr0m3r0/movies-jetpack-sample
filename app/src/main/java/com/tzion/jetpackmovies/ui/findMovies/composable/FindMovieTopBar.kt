package com.tzion.jetpackmovies.ui.findMovies.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.uicomponent.MovieTopAppBar
import com.tzion.jetpackmovies.uicomponent.TopSearchTextField

@Composable
fun FindMovieTopAppBar(
    text: String,
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
            text = text,
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

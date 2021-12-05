package com.tzion.jetpackmovies.ui.findMovies

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.FindMoviesViewModel

@Composable
fun FindMovieScreen(onBack: () -> Unit) {
    val searchInput = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            FindMovieTopAppBar(
                contentText = stringResource(R.string.find_a_movie),
                onBackEvent = onBack,
                onSearchEvent = { search ->
                    searchInput.value = search
                }
            )
        },
        content = {
            val findMoviesViewModel = hiltViewModel<FindMoviesViewModel>()
            if (searchInput.value.isNotEmpty()) {
                findMoviesViewModel.findMoviesByName(searchInput.value)
            }
            FindMovieContent(
                findMoviesViewModel = findMoviesViewModel
            )
        }
    )
}

@Composable
private fun FindMovieContent(
    findMoviesViewModel: FindMoviesViewModel
) {
    val liveDataState = findMoviesViewModel.getLiveData().observeAsState()
    liveDataState.value?.let { uiState ->
        UiStateRender(uiState)
    }
}

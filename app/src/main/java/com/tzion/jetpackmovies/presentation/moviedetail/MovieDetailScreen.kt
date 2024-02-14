package com.tzion.jetpackmovies.presentation.moviedetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import com.tzion.jetpackmovies.presentation.moviedetail.composable.DetailDisplay
import com.tzion.jetpackmovies.uicomponent.appbar.TransparentTopAppBar
import com.tzion.jetpackmovies.uicomponent.button.ArrowBack
import com.tzion.jetpackmovies.uicomponent.button.Favorite
import com.tzion.jetpackmovies.uicomponent.theme.BlackAlpha

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    onBack: () -> Unit,
    viewModel: MovieDetailViewModel = hiltViewModel<MovieDetailViewModel>()
) {
    Scaffold(
        topBar = {
            TransparentTopAppBar(
                navigationIcon = {
                    ArrowBack(
                        onClick = onBack,
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = BlackAlpha
                        )
                    )
                },
                actions = {
                    Favorite(
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = BlackAlpha
                        )
                    )
                }
            )
        },
        content = { paddingValues ->
            MovieDetailContent(
                paddingValues = paddingValues,
                viewModel = viewModel
            )
        }
    )
}

@Composable
private fun MovieDetailContent(
    paddingValues: PaddingValues,
    viewModel: MovieDetailViewModel
) {
    val userInterface = produceDetailUserInterface(viewModel = viewModel)

//    val uiState = viewModel.uiState().collectAsState()
//    remember(movieId) {
//        viewModel.loadMovieDetailById(movieId)
//        true
//    }
//    when (val currentState = uiState.value) {
//        MovieDetailUiState.Loading -> DetailLoading()
//        is MovieDetailUiState.Display -> DetailDisplay(
//            attributes = currentState.attributes,
//            paddingValues = paddingValues,
//        )
//        MovieDetailUiState.Error -> DetailError()
//    }
    DetailDisplay(userInterface = userInterface, paddingValues = paddingValues)
}

@Composable
private fun produceDetailUserInterface(viewModel: MovieDetailViewModel): DetailUserInterface {
    val uiState by produceState(
        key1 = viewModel,
        initialValue = DetailUserInterface(isLoading = true),
    ) {
        value = viewModel.getMovieInformation()
    }
    return uiState
}

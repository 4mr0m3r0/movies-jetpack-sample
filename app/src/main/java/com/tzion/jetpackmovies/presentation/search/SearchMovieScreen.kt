package com.tzion.jetpackmovies.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.navigation.NavActions
import com.tzion.jetpackmovies.presentation.search.SearchSideEffect.NoResults
import com.tzion.jetpackmovies.presentation.search.SearchSideEffect.UnexpectedError
import com.tzion.jetpackmovies.presentation.search.SearchUserIntent.FindByTitle
import com.tzion.jetpackmovies.presentation.search.SearchUserIntent.TapOnPoster
import com.tzion.jetpackmovies.presentation.search.composable.DefaultDisplay
import com.tzion.jetpackmovies.presentation.search.composable.FindMovieTopAppBar
import com.tzion.jetpackmovies.presentation.search.composable.MoviesDisplay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchMovieScreen(
    onMenu: () -> Unit,
    navActions: NavActions,
    viewModel: SearchMoviesViewModel = hiltViewModel<SearchMoviesViewModel>()
) {
    viewModel.navActions = remember { navActions }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            FindMovieTopAppBar(
                text = stringResource(R.string.find_a_movie),
                navigationIcon = {
                    IconButton(onClick = onMenu) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                },
                onSearchEvent = { querySearch ->
                    viewModel.processUserIntent(FindByTitle(query = querySearch))
                },
                scrollBehavior = scrollBehavior
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { paddingValues ->
            SearchMovieContent(
                viewModel = viewModel,
                paddingValues = paddingValues,
                snackbarHostState = snackbarHostState
            )
        }
    )
}

@Composable
private fun SearchMovieContent(
    viewModel: SearchMoviesViewModel,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState
) {
    val userInterface by viewModel.userInterface.collectAsStateWithLifecycle()
    val posters = viewModel.posters.collectAsLazyPagingItems()
    when  {
        userInterface.isEmptyScreen -> DefaultDisplay()
        else -> MoviesDisplay(
            posters = posters,
            paddingValues = paddingValues,
            onTapCard = {
                viewModel.processUserIntent(userIntent = TapOnPoster(posterId = it))
            },
        )
    }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is UnexpectedError -> snackbarHostState.showSnackbar(sideEffect.message)
                is NoResults -> snackbarHostState.showSnackbar(
                    "There are not results for query ${sideEffect.queryRequested}"
                )
            }
        }
    }
}

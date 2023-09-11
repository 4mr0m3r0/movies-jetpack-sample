package com.tzion.jetpackmovies.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tzion.jetpackmovies.ui.findMovies.FindMovieScreen
import com.tzion.jetpackmovies.ui.movieDetail.MovieDetailScreen
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun NavGraph(startDestination: String = Routes.FindMovie.route) {
    val navController = rememberNavController()
    val navActions = remember(navController) { NavActions(navController) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Search, Icons.Default.Favorite)
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                findMovie(
                    navActions = navActions,
                    onMenu = {
                        scope.launch { drawerState.open() }
                    }
                )
                movieDetail(navActions)
                favoriteMovie(navActions)
            }
        }
    )
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.findMovie(
    navActions: NavActions,
    onMenu: () -> Unit
) = composable(
    route = Routes.FindMovie.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    FindMovieScreen(
        onBack = navActions.upPress,
        onMenu = onMenu
    )
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.movieDetail(navActions: NavActions) = composable(
    route = Routes.MovieDetail.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) { backStackEntry ->
    MovieDetailScreen(
        onBack = navActions.upPress,
        movieId = backStackEntry.arguments?.getString("movieId").orEmpty()
    )
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.favoriteMovie(navActions: NavActions) = composable(
    route = Routes.FavoriteMovie.route,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {

}

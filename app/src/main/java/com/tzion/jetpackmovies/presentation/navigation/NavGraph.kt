package com.tzion.jetpackmovies.presentation.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tzion.jetpackmovies.R
import com.tzion.jetpackmovies.presentation.navigation.DrawerItem.Companion
import com.tzion.jetpackmovies.presentation.navigation.DrawerItem.Purpose
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun NavGraph(startDestination: Destination = Destination.FindMovies) {
    val navController = rememberNavController()
    val navActions = remember(navController) { NavActions(navController) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = DrawerItem.defaultDrawerItems(context = LocalContext.current)
    var selectedItem by remember { mutableStateOf(items[0]) }
    navController.addOnDestinationChangedListener { _, destination, _ ->
        when (destination.route) {
            Destination.FindMovies.route -> selectedItem = items.first()
            Destination.FavoriteMovie.route -> selectedItem = items.last()
        }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem,
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (selectedItem != item) {
                                navActions.navigatingWithDrawer(item.route)
                                selectedItem = item
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            MovieNavHost(
                navController = navController,
                startDestination = startDestination,
                scope = scope,
                drawerState = drawerState,
                navActions = navActions
            )
        }
    )
}

@ExperimentalAnimationApi
@Composable
fun MovieNavHost(
    navController: NavHostController,
    startDestination: Destination,
    scope: CoroutineScope,
    drawerState: DrawerState,
    navActions: NavActions,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        searchMovie(
            onMenu = { scope.launch { drawerState.open() } },
            navActions = navActions
        )
        movieDetail(navActions)
        favoriteMovie(navActions)
    }
}

private data class DrawerItem(val purpose: Purpose, val name: String, val icon: ImageVector, val route: Destination) {
    enum class Purpose { FIND, FAVORITE }
    companion object
}

private fun Companion.defaultDrawerItems(context: Context): List<DrawerItem> = listOf(
    DrawerItem(
        purpose = Purpose.FIND,
        name = context.getString(R.string.find_a_movie),
        icon = Icons.Default.Search,
        route = Destination.FindMovies
    ),
    DrawerItem(
        purpose = Purpose.FAVORITE,
        name = context.getString(R.string.favorites_movies),
        icon = Icons.Default.Favorite,
        route = Destination.FavoriteMovie
    ),
)

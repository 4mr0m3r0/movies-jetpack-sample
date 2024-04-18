package com.tzion.jetpackmovies.presentation.search

import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.entities.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FindUserInterface(
    val isLoading: Boolean = false,
    val posters: Flow<PagingData<Movie.Poster>> = emptyFlow(),
    val thereAreNoResults: Boolean = false,
    val errorMessage: String? = null,
    val isEmptyScreen: Boolean = false,
//    val query: String = "",
//    val lastQueryScrolled: String = "",
//    val hasNotScrolledForCurrentSearch: Boolean = false,
) {
    companion object {
        private var instance: FindUserInterface? = null
        fun defaultUi(): FindUserInterface = instance
            ?: FindUserInterface(isEmptyScreen = false).also { instance = it }
    }
}


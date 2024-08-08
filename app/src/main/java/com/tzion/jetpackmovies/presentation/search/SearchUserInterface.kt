package com.tzion.jetpackmovies.presentation.search

import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.entities.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SearchUserInterface(
    val isLoading: Boolean = false,
    val posters: Flow<PagingData<Movie.Poster>> = emptyFlow(),
    val isEmptyScreen: Boolean = false,
) {
    companion object {
        private var instance: SearchUserInterface? = null
        fun defaultUi(): SearchUserInterface = instance
            ?: SearchUserInterface(isEmptyScreen = true).also { instance = it }
    }
}


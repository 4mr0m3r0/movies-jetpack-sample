package com.tzion.jetpackmovies.presentation.moviedetail

import com.tzion.jetpackmovies.uicomponent.template.AttrsDetailTemplate

data class DetailUserInterface(
    val isLoading: Boolean = false,
    val attributes: AttrsDetailTemplate? = null,
    val errorMessage: String? = null
)

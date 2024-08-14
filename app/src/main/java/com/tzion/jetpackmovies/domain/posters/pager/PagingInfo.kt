package com.tzion.jetpackmovies.domain.posters.pager

import com.tzion.jetpackmovies.domain.entities.Movie

data class PagingInfo(
    val posters: List<Movie.Poster>?,
    val totalResults: Int?,
)

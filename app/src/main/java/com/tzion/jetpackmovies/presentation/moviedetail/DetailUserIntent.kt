package com.tzion.jetpackmovies.presentation.moviedetail

import com.tzion.jetpackmovies.domain.SeeMovieDetail
import com.tzion.jetpackmovies.presentation.favorites.UserIntent


class EnterDetailSection(private val seeMovieDetail: SeeMovieDetail) : UserIntent {
    var movieId: String? = null
    override suspend fun execute() {
        seeMovieDetail.getMovieDetailById(movieId = movieId)
    }
}
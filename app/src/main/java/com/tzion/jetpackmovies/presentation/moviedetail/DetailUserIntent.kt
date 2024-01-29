package com.tzion.jetpackmovies.presentation.moviedetail

import com.tzion.jetpackmovies.domain.GetMovieDetail
import com.tzion.jetpackmovies.presentation.UserIntent


class EnterDetailSection(private val getMovieDetail: GetMovieDetail) : UserIntent {
    var movieId: String? = null
    override suspend fun execute() {
        getMovieDetail.getMovieDetailById(movieId = movieId)
    }
}
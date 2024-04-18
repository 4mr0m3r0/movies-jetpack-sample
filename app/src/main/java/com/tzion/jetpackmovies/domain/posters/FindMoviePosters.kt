package com.tzion.jetpackmovies.domain.posters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.pager.PostingPagingSource
import kotlinx.coroutines.flow.Flow

class FindMoviePosters(
    private val remoteFacade: RemoteFacade,
    private val movie: Movie,
) {
    fun findByTitle(title: String?): Flow<PagingData<Movie.Poster>> {
        val verifiedTitle = movie.verifyTitleAndGetTrimValue(title)
        return Pager(
            config = PagingConfig(
                pageSize = remoteFacade.pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PostingPagingSource(remoteFacade, verifiedTitle)
            }
        ).flow
    }

}

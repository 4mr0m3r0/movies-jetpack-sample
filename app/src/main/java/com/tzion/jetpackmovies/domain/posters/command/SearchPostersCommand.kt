package com.tzion.jetpackmovies.domain.posters.command

import androidx.paging.PagingData
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.domain.posters.FindMoviePosters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class SearchPostersCommand(
    private val useCase: FindMoviePosters,
    private val query: String,
) : PostersCommand {

    override suspend fun execute() {
        pagingPosters = useCase.findByTitle(title = query)
    }
}

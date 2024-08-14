package com.tzion.jetpackmovies.domain.posters.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tzion.jetpackmovies.domain.boundary.RemoteFacade
import com.tzion.jetpackmovies.domain.entities.Movie

class PostingPagingSource(private val network: RemoteFacade, private val query: String) : PagingSource<Int, Movie.Poster>() {
    private var totalPages: Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie.Poster> {
        val currentPage = params.key ?: STARTING_PAGE_INDEX
        return try {
            val pagingInfo = network.findMoviePostersByName(
                name = query,
                page = currentPage
            )
            LoadResult.Page(
                data = pagingInfo.posters.orEmpty(),
                prevKey = null,
                nextKey = calculateNextPage(
                    currentPage = currentPage,
                    totalResults = pagingInfo.totalResults
                )
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    private fun calculateNextPage(currentPage: Int, totalResults: Int?): Int? = try {
        if (totalPages == 0 && totalResults != null) {
            totalPages = totalResults / network.pageSize
        }
        if (currentPage + 1 > totalPages) null else currentPage + 1
    } catch (e: NumberFormatException) {
        null
    }

    override fun getRefreshKey(state: PagingState<Int, Movie.Poster>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(anchorPosition = position)
            val prevKey = anchorPage?.prevKey
            val nextKey = anchorPage?.nextKey
            prevKey?.plus(1) ?: nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}
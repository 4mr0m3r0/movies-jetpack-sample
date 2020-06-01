package com.tzion.openmoviesdatabase.movies.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.tzion.openmoviesdatabase.factory.RandomFactory
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import com.tzion.openmoviesdatabase.movies.factory.MovieDetailFactory.makeDomainMovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

class GetMovieDetailUseCaseTest {

    private val repository = mock<Repository>()
    private val useCase = GetMovieDetailUseCase(repository)

    @Test
    fun `given DomainMovieDetail, when getMovieDetailById, then return data`() {
        val domainMovieDetail = makeDomainMovieDetail()
        stubRepositoryGetMovieDetailById(domainMovieDetail)
        runBlockingTest {

        }
    }

    private fun stubRepositoryGetMovieDetailById(domainMovieDetail: DomainMovieDetail) {
//        whenever(repository.getMovieDetailById(RandomFactory.generateString())).thenReturn()
    }

}
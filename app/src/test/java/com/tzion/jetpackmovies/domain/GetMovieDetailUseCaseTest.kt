package com.tzion.jetpackmovies.domain

import com.nhaarman.mockito_kotlin.mock
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.domain.repository.Repository
import com.tzion.jetpackmovies.factory.MovieDetailFactory.makeDomainMovieDetail
import kotlinx.coroutines.test.runBlockingTest
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
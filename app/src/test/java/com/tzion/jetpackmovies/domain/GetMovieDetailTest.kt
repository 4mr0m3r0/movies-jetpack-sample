package com.tzion.jetpackmovies.domain

import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.domain.model.DomainMovieDetail
import com.tzion.jetpackmovies.factory.MovieDetailFactory.makeDomainMovieDetail
import com.tzion.jetpackmovies.factory.RandomFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetMovieDetailTest {

    private val dataGateway = mockk<DataGateway>()
    private val useCase = GetMovieDetail(dataGateway)

    @Test
    fun `given DomainMovieDetail, when getMovieDetailById, then return data`() = runBlocking {
        val domainMovieDetail = makeDomainMovieDetail()
        stubRepositoryGetMovieDetailById(domainMovieDetail)

        val resultFlow = useCase.getMovieDetailById(RandomFactory.generateString())

        resultFlow.collect {
            assertEquals(domainMovieDetail, it)
        }
    }

    private fun stubRepositoryGetMovieDetailById(domainMovieDetail: DomainMovieDetail) {
        coEvery {
            dataGateway.getMovieDetailById(RandomFactory.generateString())
        } returns flow { emit(domainMovieDetail) }
    }
}

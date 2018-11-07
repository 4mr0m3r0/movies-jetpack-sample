package com.tzion.remote.movie

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.tzion.data.movie.model.MovieEntity
import com.tzion.remote.movie.model.RemoteMovie
import com.tzion.remote.movie.model.RemoteSearch
import com.tzion.remote.test.factory.DataFactory
import com.tzion.remote.test.factory.MovieDataFactory
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieRemoteImplTest {

    private val mapper = mock<MovieRemoteMapper>()
    private val restApi = mock<MovieRestApi>()
    private val remote = MovieRemoteImpl(restApi, mapper)


    @Test
    fun getClientCompletes() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(MovieDataFactory.makeMovieResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), MovieDataFactory.makeMovieEntity())

        val testObserver = remote.findMoviesByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun getClientCallsServer() {
        val param = DataFactory.randomUuid()
        stubClientRestApiClients(Single.just(MovieDataFactory.makeMovieResponse()), param)
        stubClientResponseModelMapperMapFromModel(any(), MovieDataFactory.makeMovieEntity())

        remote.findMoviesByText(param).test()
        verify(restApi).getMovies(param)
    }

    @Test
    fun getClientReturnsData() {
        val param = DataFactory.randomUuid()
        val response = MovieDataFactory.makeMovieResponse()
        stubClientRestApiClients(Single.just(response), param)
        val entities = mutableListOf<MovieEntity>()
        response.search.forEach {
            val entity = MovieDataFactory.makeMovieEntity()
            entities.add(entity)
            stubClientResponseModelMapperMapFromModel(it, entity)
        }
        val testObserver = remote.findMoviesByText(param).test()
        testObserver.assertValue(entities)
    }

    private fun stubClientRestApiClients(singleObservable: Single<RemoteSearch>?, param: String?) {
        whenever(restApi.getMovies(param)).thenReturn(singleObservable)
    }

    private fun stubClientResponseModelMapperMapFromModel(remote: RemoteMovie,
                                                          entity: MovieEntity) {
        whenever(mapper.mapFromRemote(remote)).thenReturn(entity)
    }

}
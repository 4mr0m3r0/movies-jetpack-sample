package com.tzion.data.movie.store

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.segtechcu.data.test.factory.DataFactory
import com.tzion.data.movie.model.MovieEntity
import com.tzion.data.movie.repository.MovieRemote
import com.tzion.data.test.factory.MovieFactory
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieRemoteDataStoreTest {

    private val remote = mock<MovieRemote>()
    private val store = MovieRemoteDataStore(remote)

    @Test
    fun findMoviesByTextCompletes() {
        val param = DataFactory.randomString()
        stubRemoteFindMoviesByText(Single.just(listOf(MovieFactory.makeMovieEntity())), param)
        val testObserver = store.findMoviesByText(param).test()
        testObserver.assertComplete()
    }

    @Test
    fun findMoviesByTextReturnsData() {
        val param = DataFactory.randomString()
        val data = listOf(MovieFactory.makeMovieEntity())
        stubRemoteFindMoviesByText(Single.just(data), param)
        val testObserver = store.findMoviesByText(param).test()
        testObserver.assertValue(data)
    }

    private fun stubRemoteFindMoviesByText(singleObservable: Single<List<MovieEntity>>, param: String?) {
        whenever(remote.findMoviesByText(param)).thenReturn(singleObservable)
    }

}
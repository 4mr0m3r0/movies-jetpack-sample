package com.tzion.domain.movie

import com.nhaarman.mockito_kotlin.whenever
import com.tzion.domain.executor.PostExecutionThread
import com.tzion.domain.movie.model.Movie
import com.tzion.domain.test.MovieDataFactory
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FindMoviesUseCaseTest {

    private lateinit var findMoviesUseCase: FindMoviesUseCase
    @Mock lateinit var movieRepository: MovieRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        findMoviesUseCase = FindMoviesUseCase(movieRepository, postExecutionThread)
    }

    @Test
    fun findMoviesUseCaseComplete() {
        val param = MovieDataFactory.randomUuid()
        stubFindMoviesUseCase(Single.just(MovieDataFactory.makeMovieList(2)), param)
        val testObserver = findMoviesUseCase.buildUseCaseObservable(FindMoviesUseCase.Params(param)).test()
        testObserver.assertComplete()
    }

    @Test
    fun findMoviesUseCaseReturnsData() {
        val param = MovieDataFactory.randomUuid()
        val movies = MovieDataFactory.makeMovieList(2)
        stubFindMoviesUseCase(Single.just(movies), param)
        val testObserver = findMoviesUseCase.buildUseCaseObservable(FindMoviesUseCase.Params(param)).test()
        testObserver.assertValue(movies)
    }

    private fun stubFindMoviesUseCase(singleObservable: Single<List<Movie>>, param: String?) {
        whenever(movieRepository.findMoviesByText(param)).thenReturn(singleObservable)
    }

}
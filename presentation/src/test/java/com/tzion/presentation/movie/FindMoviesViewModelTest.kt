package com.tzion.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import com.tzion.domain.movie.FindMoviesUseCase
import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.ResourceState
import com.tzion.presentation.movie.model.MoviePresentation
import com.tzion.presentation.test.factory.DataFactory
import com.tzion.presentation.test.factory.MovieFactory
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor
import java.lang.RuntimeException

@RunWith(JUnit4::class)
class FindMoviesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var findMoviesUseCase = mock<FindMoviesUseCase>()
    var movieMapper = mock<MoviePresentationMapper>()
    var movieViewModel = FindMoviesViewModel(findMoviesUseCase, movieMapper)

    @Captor
    val captor = argumentCaptor<DisposableSingleObserver<List<Movie>>>()

    @Test
    fun fetchMoviesExecutesUseCase() {
        val param = DataFactory.randomString()
        movieViewModel.findMoviesByText(param)

        verify(findMoviesUseCase, times(1)).execute(any(), eq(FindMoviesUseCase.Params(param)))
    }

    @Test
    fun fetchMoviesReturnsSuccess() {
        val param = DataFactory.randomString()
        val movies = MovieFactory.makeMovieList(2)
        val movieViews = MovieFactory.makeMovieViewList(2)
        stubMovieMapperToView(movieViews[0], movies[0])
        stubMovieMapperToView(movieViews[1], movies[1])

        movieViewModel.findMoviesByText(param)
        verify(findMoviesUseCase).execute(captor.capture(), eq(FindMoviesUseCase.Params(param)))
        captor.firstValue.onSuccess(movies)
        assertEquals(ResourceState.SUCCESS, movieViewModel.getMoviesLiveData().value?.status)
    }

    @Test
    fun fetchMoviesReturnsData() {
        val param = DataFactory.randomString()
        val movies = MovieFactory.makeMovieList(2)
        val movieViews = MovieFactory.makeMovieViewList(2)
        stubMovieMapperToView(movieViews[0], movies[0])
        stubMovieMapperToView(movieViews[1], movies[1])

        movieViewModel.findMoviesByText(param)
        verify(findMoviesUseCase).execute(captor.capture(), eq(FindMoviesUseCase.Params(param)))
        captor.firstValue.onSuccess(movies)
        assertEquals(movieViews, movieViewModel.getMoviesLiveData().value?.data)
    }

    @Test
    fun fetchMoviesReturnsError() {
        val param = DataFactory.randomString()
        movieViewModel.findMoviesByText(param)
        verify(findMoviesUseCase).execute(captor.capture(), eq(FindMoviesUseCase.Params(param)))
        captor.firstValue.onError(RuntimeException())
        assertEquals(ResourceState.ERROR, movieViewModel.getMoviesLiveData().value?.status)
    }

    @Test
    fun fetchMoviesReturnsMessageForError() {
        val param = DataFactory.randomString()
        val errorMessage = DataFactory.randomString()
        movieViewModel.findMoviesByText(param)
        verify(findMoviesUseCase).execute(captor.capture(), eq(FindMoviesUseCase.Params(param)))
        captor.firstValue.onError(RuntimeException(errorMessage))
        assertEquals(errorMessage, movieViewModel.getMoviesLiveData().value?.message)
    }

    private fun stubMovieMapperToView(movieView: MoviePresentation, movie: Movie) {
        whenever(movieMapper.mapToPresentation(movie)).thenReturn(movieView)
    }


}
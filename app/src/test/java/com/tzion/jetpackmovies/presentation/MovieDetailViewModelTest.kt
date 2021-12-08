package com.tzion.jetpackmovies.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tzion.jetpackmovies.domain.GetMovieDetailUseCase
import com.tzion.jetpackmovies.domain.ManageFavoriteMoviesUseCase
import com.tzion.jetpackmovies.domain.repository.Repository
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import io.mockk.mockk
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val repository = mockk<Repository>()
    private val getMovieDetailUseCase = GetMovieDetailUseCase(repository)
    private val manageFavoriteMoviesUseCase = ManageFavoriteMoviesUseCase(repository)
    private val mapper = UiMovieDetailMapper()
    private val viewModel = MovieDetailViewModel(
        getMovieDetailUseCase = getMovieDetailUseCase,
        manageFavoriteMoviesUseCase = manageFavoriteMoviesUseCase,
        mapper = mapper
    )

    @Test
    fun `getLiveData not null`() {
        assertNotNull(viewModel.getLiveData())
    }
}

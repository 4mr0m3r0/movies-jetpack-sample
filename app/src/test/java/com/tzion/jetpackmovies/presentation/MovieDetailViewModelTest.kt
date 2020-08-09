package com.tzion.jetpackmovies.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.mock
import com.tzion.jetpackmovies.domain.GetMovieDetailUseCase
import com.tzion.jetpackmovies.domain.repository.Repository
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val repository = mock<Repository>()
    private val useCase = GetMovieDetailUseCase(repository)
    private val mapper = UiMovieDetailMapper()
    private val viewModel = MovieDetailViewModel(useCase, mapper)

    @Test
    fun `getLiveData not null`() {
        assertNotNull(viewModel.getLiveData())
    }

}
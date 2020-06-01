package com.tzion.openmoviesdatabase.movies.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.mock
import com.tzion.openmoviesdatabase.movies.domain.GetMovieDetailUseCase
import com.tzion.openmoviesdatabase.movies.domain.repository.Repository
import com.tzion.openmoviesdatabase.movies.presentation.mapper.UiMovieDetailMapper
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
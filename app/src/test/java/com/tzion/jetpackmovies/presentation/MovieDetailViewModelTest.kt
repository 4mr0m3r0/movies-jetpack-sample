package com.tzion.jetpackmovies.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tzion.jetpackmovies.domain.GetMovieDetail
import com.tzion.jetpackmovies.domain.ManageFavoriteMovies
import com.tzion.jetpackmovies.domain.gateway.DataGateway
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import io.mockk.mockk
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class MovieDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dataGateway = mockk<DataGateway>()
    private val getMovieDetail = GetMovieDetail(dataGateway)
    private val manageFavoriteMovies = ManageFavoriteMovies(dataGateway)
    private val mapper = UiMovieDetailMapper()
    private val viewModel = MovieDetailViewModel(
        getMovieDetail = getMovieDetail,
        manageFavoriteMovies = manageFavoriteMovies,
        mapper = mapper
    )

    @Test
    fun `getLiveData not null`() {
        assertNotNull(viewModel.uiState())
    }
}

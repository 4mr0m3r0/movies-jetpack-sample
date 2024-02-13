package com.tzion.jetpackmovies.presentation.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.SeeMovieDetail
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.mapper.ViewMovieDetailMapper
import com.tzion.jetpackmovies.presentation.uistates.MovieDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val seeMovieDetail: SeeMovieDetail,
    private val manageFavoriteMovie: ManageFavoriteMovie,
    private val mapper: ViewMovieDetailMapper
) : ViewModel() {

    private val uiState: MutableStateFlow<MovieDetailUiState> =
        MutableStateFlow(MovieDetailUiState.Loading)

    fun uiState(): StateFlow<MovieDetailUiState> = uiState

    fun loadMovieDetailById(movieId: String?, coroutineScope: CoroutineScope = viewModelScope) {
        coroutineScope.launch {

//            uiState.value = MovieDetailUiState.Loading
//            getMovieDetail
//                .getMovieDetailById(movieId)
//                .map { domainMovieDetail ->
//                    with(mapper) { domainMovieDetail.fromDomainToUi() }
//                }
//                .catch { uiState.value = MovieDetailUiState.Error }
//                .collect { uiMovieDetail ->
//                    uiState.value = MovieDetailUiState.Display(uiMovieDetail)
//                }
        }
    }

    fun addMovieToFavorites(movieId: String, favoriteMovie: Movie.Favorite) {
        viewModelScope.launch {
            manageFavoriteMovie.saveFavoriteMovie(favoriteMovie)
        }
    }
}

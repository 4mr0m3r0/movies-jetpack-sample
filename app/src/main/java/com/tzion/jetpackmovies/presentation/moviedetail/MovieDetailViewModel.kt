package com.tzion.jetpackmovies.presentation.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.ManageFavoriteMovie
import com.tzion.jetpackmovies.domain.SeeMovieDetail
import com.tzion.jetpackmovies.domain.entities.Movie
import com.tzion.jetpackmovies.presentation.mapper.UiMovieDetailMapper
import com.tzion.jetpackmovies.presentation.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val seeMovieDetail: SeeMovieDetail,
    private val manageFavoriteMovie: ManageFavoriteMovie,
    private val mapper: UiMovieDetailMapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val movieId = savedStateHandle.get<String>(Destination.Argument.Name.MOVIE_ID)

    suspend fun getMovieInformation(): DetailUserInterface = try {
        val information = seeMovieDetail.getMovieDetailById(movieId)
        DetailUserInterface(attributes = with(mapper) { information.toAttributes() })
    } catch (e: Exception) {
        DetailUserInterface(errorMessage = e.localizedMessage)
    }

    fun addMovieToFavorites(movieId: String, favoriteMovie: Movie.Favorite) {
        viewModelScope.launch {
            manageFavoriteMovie.saveFavoriteMovie(favoriteMovie)
        }
    }
}

package com.tzion.jetpackmovies.data

import androidx.paging.DataSource
import com.tzion.jetpackmovies.data.database.DatabaseBuilder
import com.tzion.jetpackmovies.data.mapper.DataFavoriteMapper
import com.tzion.jetpackmovies.domain.boundary.DataGateway
import com.tzion.jetpackmovies.domain.entities.Movie
import javax.inject.Inject

class MovieData @Inject constructor(
    private val databaseBuilder: DatabaseBuilder,
    private val favoriteMovieMapper: DataFavoriteMapper
) : DataGateway {

    override suspend fun saveFavoriteMovie(favoriteMovie: Movie.Favorite) {
        databaseBuilder
            .favoriteMovieDao()
            .insertFavoriteMovie(
                with(favoriteMovieMapper) { favoriteMovie.toData() }
            )
    }

    override fun getFavoriteMovies(): DataSource.Factory<Int, Movie.Favorite> = databaseBuilder
        .favoriteMovieDao()
        .getFavoriteMovies()
        .map { dataFavoriteMovie ->
            with(favoriteMovieMapper) { dataFavoriteMovie.toFavorite() }
        }
}

package com.tzion.jetpackmovies.data.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tzion.jetpackmovies.data.database.DatabaseConfigs.Queries.DELETE_ALL_FROM_FAVORITE_MOVIES
import com.tzion.jetpackmovies.data.database.DatabaseConfigs.Queries.SELECT_ALL_FROM_FAVORITE_MOVIES
import com.tzion.jetpackmovies.data.model.CacheFavoriteMovie

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(favoriteMovie: CacheFavoriteMovie)

    @Query(SELECT_ALL_FROM_FAVORITE_MOVIES)
    fun getFavoriteMovies(): DataSource.Factory<Int, CacheFavoriteMovie>

    @Query(DELETE_ALL_FROM_FAVORITE_MOVIES)
    suspend fun deleteAll()
}

package com.tzion.jetpackmovies.data.cache.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tzion.jetpackmovies.data.cache.database.DatabaseConfigs.Queries.DELETE_ALL_FROM_FAVORITE_MOVIES
import com.tzion.jetpackmovies.data.cache.database.DatabaseConfigs.Queries.SELECT_ALL_FROM_FAVORITE_MOVIES
import com.tzion.jetpackmovies.data.cache.model.CacheMovieDetail

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteMovie(movieDetail: CacheMovieDetail)

    @Query(SELECT_ALL_FROM_FAVORITE_MOVIES)
    fun getFavoriteMovies(): DataSource.Factory<Int, CacheMovieDetail>

    @Query(DELETE_ALL_FROM_FAVORITE_MOVIES)
    fun deleteAll()

}
package com.tzion.cache.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tzion.cache.movie.MovieConstants.DELETE_MOVIES
import com.tzion.cache.movie.MovieConstants.SELECT_MOVIES
import com.tzion.cache.movie.model.CachedMovie
import io.reactivex.Flowable

@Dao
abstract class CachedMovieDao {

    @Query(SELECT_MOVIES)
    @JvmSuppressWildcards
    abstract fun getMovies(): Flowable<List<CachedMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertMovies(clients: List<CachedMovie>)

    @Query(DELETE_MOVIES)
    abstract fun deleteMovies()

}
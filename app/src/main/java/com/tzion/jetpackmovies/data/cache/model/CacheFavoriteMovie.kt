package com.tzion.jetpackmovies.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tzion.jetpackmovies.data.cache.database.DatabaseConfigs

@Entity(tableName = DatabaseConfigs.Names.Tables.FAVORITE_MOVIES)
data class CacheFavoriteMovie(
    @PrimaryKey
    @ColumnInfo(name = DatabaseConfigs.Names.Columns.FAVORITE_MOVIE_ID)
    val id: String,
    val title: String,
    val year: String,
    val rated: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String,
    val language: String,
    val country: String,
    val awards: String,
    val poster: String,
    val metascore: String,
    val rating: String,
    val votes: String,
    val type: String,
    val dvd: String,
    @ColumnInfo(name = DatabaseConfigs.Names.Columns.BOX_OFFICE)
    val boxOffice: String,
    val production: String,
    val website: String
)
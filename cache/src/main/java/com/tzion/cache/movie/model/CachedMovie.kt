package com.tzion.cache.movie.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tzion.cache.movie.MovieConstants

@Entity(tableName = MovieConstants.TABLE_NAME)
data class CachedMovie (
    @PrimaryKey
    @ColumnInfo(name = MovieConstants.COLUMN_MOVIE_ID)
    var id: String,
    @ColumnInfo(name = MovieConstants.COLUMN_TITLE)
    var title: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_YEAR)
    var year: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_RATED)
    var rated: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_RELEASED)
    var released: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_RUNTIME)
    var runtime: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_GENRE)
    var genre: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_DIRECTOR)
    var director: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_WRITER)
    var writer: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_ACTORS)
    var actors: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_PLOT)
    var plot: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_LANGUAGE)
    var language: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_COUNTRY)
    var country: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_AWARDS)
    var awards: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_POSTER)
    var poster: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_METASCORE)
    var metascore: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_IMDBRATING)
    var imdbRating: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_IMDBVOTES)
    var imdbVotes: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_TYPE)
    var type: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_DVD)
    var DVD: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_BOXOFFICE)
    var boxOffice: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_PRODUCTION)
    var production: String?,
    @ColumnInfo(name = MovieConstants.COLUMN_WEBSITE)
    var website: String?
)
package com.tzion.cache.movie

object MovieConstants {

    const val TABLE_NAME = "movies"

    const val COLUMN_MOVIE_ID = "imdbID"

    const val COLUMN_TITLE = "title"

    const val COLUMN_YEAR = "year"

    const val COLUMN_RATED = "rated"

    const val COLUMN_RELEASED = "released"

    const val COLUMN_RUNTIME = "runtime"

    const val COLUMN_GENRE = "genre"

    const val COLUMN_DIRECTOR = "director"

    const val COLUMN_WRITER = "writer"

    const val COLUMN_ACTORS = "actors"

    const val COLUMN_PLOT = "plot"

    const val COLUMN_LANGUAGE = "language"

    const val COLUMN_COUNTRY = "country"

    const val COLUMN_AWARDS = "awards"

    const val COLUMN_POSTER = "poster"

    const val COLUMN_METASCORE = "metascore"

    const val COLUMN_IMDBRATING = "imdbRating"

    const val COLUMN_IMDBVOTES = "imdbVotes"

    const val COLUMN_TYPE = "type"

    const val COLUMN_DVD = "DVD"

    const val COLUMN_BOXOFFICE = "boxOffice"

    const val COLUMN_PRODUCTION = "production"

    const val COLUMN_WEBSITE = "website"

    const val SELECT_MOVIES = "SELECT * FROM $TABLE_NAME"

    const val DELETE_MOVIES = "DELETE FROM $TABLE_NAME"

}
package com.tzion.jetpackmovies.data.cache.database

object DatabaseConfigs {

    /**
     * For Alter a Table might be something like this
     * const val MIGRATION_ALTER_TABLE = "ALTER TABLE Task ADD notes TEXT NOT NULL DEFAULT ''"
     */
    object Queries {
        const val SELECT_ALL_FROM_FAVORITE_MOVIES = "SELECT * FROM ${Names.Tables.FAVORITE_MOVIES}"
        const val DELETE_ALL_FROM_FAVORITE_MOVIES = "DELETE FROM ${Names.Tables.FAVORITE_MOVIES}"
    }

    object Names {
        const val DATABASE = "movies-db"

        object Tables {
            const val FAVORITE_MOVIES = "favorite_movies"
        }

        object Columns {
            const val FAVORITE_MOVIE_ID = "favorite_movie_id"
            const val TITLE = "title"
            const val YEAR = "year"
            const val RATED = "rated"
            const val RELEASED = "released"
            const val RUNTIME = "runtime"
            const val GENRE = "genre"
            const val DIRECTOR = "director"
            const val WRITER = "writer"
            const val ACTORS = "actors"
            const val PLOT = "plot"
            const val LANGUAGE = "language"
            const val COUNTRY = "country"
            const val AWARDS = "awards"
            const val POSTER = "poster"
            const val METASCORE = "metascore"
            const val RATING = "rating"
            const val VOTES = "votes"
            const val TYPE = "type"
            const val DVD = "dvd"
            const val BOX_OFFICE = "box_office"
            const val PRODUCTION = "production"
            const val WEBSITE = "website"
        }
    }
}

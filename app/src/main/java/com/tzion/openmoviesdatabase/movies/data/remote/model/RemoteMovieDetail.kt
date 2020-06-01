package com.tzion.openmoviesdatabase.movies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.ACTORS
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.AWARDS
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.BOX_OFFICE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.COUNTRY
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.DIRECTOR
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.DVD
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.GENRE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.IMDB_ID
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.IMDB_RATING
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.IMDB_VOTES
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.LANGUAGE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.METASCORE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.PLOT
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.POSTER
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.PRODUCTION
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.RATED
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.RATINGS
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.RELEASED
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.RESPONSE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.RUNTIME
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.TITLE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.TYPE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.WEBSITE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.WRITER
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.YEAR

data class RemoteMovieDetail(@SerializedName(TITLE) val title: String?,
                             @SerializedName(YEAR) val year: String?,
                             @SerializedName(RATED) val rated: String?,
                             @SerializedName(RELEASED) val released: String?,
                             @SerializedName(RUNTIME) val runtime: String?,
                             @SerializedName(GENRE) val genre: String?,
                             @SerializedName(DIRECTOR) val director: String?,
                             @SerializedName(WRITER) val writer: String?,
                             @SerializedName(ACTORS) val actors: String?,
                             @SerializedName(PLOT) val plot: String?,
                             @SerializedName(LANGUAGE) val language: String?,
                             @SerializedName(COUNTRY) val country: String?,
                             @SerializedName(AWARDS) val awards: String?,
                             @SerializedName(POSTER) val poster: String?,
                             @SerializedName(RATINGS) val ratings: List<RemoteRating>?,
                             @SerializedName(METASCORE) val metascore: String?,
                             @SerializedName(IMDB_RATING) val imdbRating: String?,
                             @SerializedName(IMDB_VOTES) val imdbVotes: String?,
                             @SerializedName(IMDB_ID) val imdbId: String?,
                             @SerializedName(TYPE) val type: String?,
                             @SerializedName(DVD) val dvd: String?,
                             @SerializedName(BOX_OFFICE) val boxOffice: String?,
                             @SerializedName(PRODUCTION) val production: String?,
                             @SerializedName(WEBSITE) val website: String?,
                             @SerializedName(RESPONSE) val response: String?)
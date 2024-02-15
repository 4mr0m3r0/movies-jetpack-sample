package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.network.model.Constants.ACTORS
import com.tzion.jetpackmovies.network.model.Constants.AWARDS
import com.tzion.jetpackmovies.network.model.Constants.BOX_OFFICE
import com.tzion.jetpackmovies.network.model.Constants.COUNTRY
import com.tzion.jetpackmovies.network.model.Constants.DIRECTOR
import com.tzion.jetpackmovies.network.model.Constants.DVD
import com.tzion.jetpackmovies.network.model.Constants.GENRE
import com.tzion.jetpackmovies.network.model.Constants.IMDB_ID
import com.tzion.jetpackmovies.network.model.Constants.IMDB_RATING
import com.tzion.jetpackmovies.network.model.Constants.IMDB_VOTES
import com.tzion.jetpackmovies.network.model.Constants.LANGUAGE
import com.tzion.jetpackmovies.network.model.Constants.METASCORE
import com.tzion.jetpackmovies.network.model.Constants.PLOT
import com.tzion.jetpackmovies.network.model.Constants.POSTER
import com.tzion.jetpackmovies.network.model.Constants.PRODUCTION
import com.tzion.jetpackmovies.network.model.Constants.RATED
import com.tzion.jetpackmovies.network.model.Constants.RATINGS
import com.tzion.jetpackmovies.network.model.Constants.RELEASED
import com.tzion.jetpackmovies.network.model.Constants.RESPONSE
import com.tzion.jetpackmovies.network.model.Constants.RUNTIME
import com.tzion.jetpackmovies.network.model.Constants.TITLE
import com.tzion.jetpackmovies.network.model.Constants.TYPE
import com.tzion.jetpackmovies.network.model.Constants.WEBSITE
import com.tzion.jetpackmovies.network.model.Constants.WRITER
import com.tzion.jetpackmovies.network.model.Constants.YEAR

data class RemoteMovieDetail(
    @SerializedName(TITLE) val title: String?,
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
    @SerializedName(RESPONSE) val response: String?
)

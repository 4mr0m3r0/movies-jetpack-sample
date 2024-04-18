package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.network.model.Constants.IMDBID
import com.tzion.jetpackmovies.network.model.Constants.POSTER
import com.tzion.jetpackmovies.network.model.Constants.TITLE
import com.tzion.jetpackmovies.network.model.Constants.TYPE
import com.tzion.jetpackmovies.network.model.Constants.YEAR

data class RemoteMovieDetail(
    @SerializedName(TITLE) val title: String?,
    @SerializedName(YEAR) val year: String?,
    @SerializedName(IMDBID) val rated: String?,
    @SerializedName(TYPE) val released: String?,
    @SerializedName(POSTER) val runtime: String?,
    @SerializedName("Rated") val genre: String?,
    @SerializedName("Released") val director: String?,
    @SerializedName("Runtime") val writer: String?,
    @SerializedName("Genre") val actors: String?,
    @SerializedName("Director") val plot: String?,
    @SerializedName("Writer") val language: String?,
    @SerializedName("Actors") val country: String?,
    @SerializedName("Plot") val awards: String?,
    @SerializedName("Language") val poster: String?,
    @SerializedName("Country") val ratings: List<RemoteRating>?,
    @SerializedName("Awards") val metascore: String?,
    @SerializedName("Ratings") val imdbRating: String?,
    @SerializedName("Metascore") val imdbVotes: String?,
    @SerializedName("imdbRating") val imdbId: String?,
    @SerializedName("imdbVotes") val type: String?,
    @SerializedName("imdbID") val dvd: String?,
    @SerializedName("DVD") val boxOffice: String?,
    @SerializedName("BoxOffice") val production: String?,
    @SerializedName("Production") val website: String?,
    @SerializedName("Website") val response: String?
)

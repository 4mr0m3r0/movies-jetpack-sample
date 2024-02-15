package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.network.model.Constants.IMDBID
import com.tzion.jetpackmovies.network.model.Constants.POSTER
import com.tzion.jetpackmovies.network.model.Constants.TITLE
import com.tzion.jetpackmovies.network.model.Constants.TYPE
import com.tzion.jetpackmovies.network.model.Constants.YEAR

data class RemoteMovie(
    @SerializedName(TITLE) val title: String?,
    @SerializedName(YEAR) val year: String?,
    @SerializedName(IMDBID) val imdbId: String,
    @SerializedName(TYPE) val type: String,
    @SerializedName(POSTER) val poster: String
)

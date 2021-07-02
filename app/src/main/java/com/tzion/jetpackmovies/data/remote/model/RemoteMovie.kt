package com.tzion.jetpackmovies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.data.remote.model.Constants.IMDBID
import com.tzion.jetpackmovies.data.remote.model.Constants.POSTER
import com.tzion.jetpackmovies.data.remote.model.Constants.TITLE
import com.tzion.jetpackmovies.data.remote.model.Constants.TYPE
import com.tzion.jetpackmovies.data.remote.model.Constants.YEAR

data class RemoteMovie(
    @SerializedName(TITLE) val title: String?,
    @SerializedName(YEAR) val year: String?,
    @SerializedName(IMDBID) val imdbId: String,
    @SerializedName(TYPE) val type: String,
    @SerializedName(POSTER) val poster: String
)

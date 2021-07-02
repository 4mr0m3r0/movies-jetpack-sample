package com.tzion.jetpackmovies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.data.remote.model.Constants.SOURCE
import com.tzion.jetpackmovies.data.remote.model.Constants.VALUE

data class RemoteRating(
    @SerializedName(SOURCE) val source: String?,
    @SerializedName(VALUE) val value: String?
)

package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.network.model.Constants.SOURCE
import com.tzion.jetpackmovies.network.model.Constants.VALUE

data class RemoteRating(
    @SerializedName(SOURCE) val source: String?,
    @SerializedName(VALUE) val value: String?
)

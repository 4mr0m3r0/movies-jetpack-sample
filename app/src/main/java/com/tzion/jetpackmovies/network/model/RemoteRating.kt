package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName

data class RemoteRating(
    @SerializedName("Source") val source: String?,
    @SerializedName("Value") val value: String?
)

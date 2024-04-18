package com.tzion.jetpackmovies.network.model

import com.google.gson.annotations.SerializedName

data class RemoteSearch(
    @SerializedName("Search") val search: List<RemoteMovie>,
    @SerializedName("totalResults") val totalResults: String,
)

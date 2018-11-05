package com.tzion.remote.movie.model

import com.google.gson.annotations.SerializedName

class RemoteMovie (@SerializedName("Title") val title: String?,
                   @SerializedName("Year") val year: String?,
                   @SerializedName("imdbID") val imdbId: String,
                   @SerializedName("Type") val type: String,
                   @SerializedName("Poster") val poster: String)
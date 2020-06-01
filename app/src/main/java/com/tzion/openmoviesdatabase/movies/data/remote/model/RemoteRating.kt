package com.tzion.openmoviesdatabase.movies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.SOURCE
import com.tzion.openmoviesdatabase.movies.data.remote.model.Constants.VALUE

data class RemoteRating(@SerializedName(SOURCE) val source: String?,
                        @SerializedName(VALUE) val value: String?)
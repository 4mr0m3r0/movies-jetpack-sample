package com.tzion.jetpackmovies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tzion.jetpackmovies.data.remote.model.Constants.SEARCH

data class RemoteSearch(@SerializedName(SEARCH) val search: List<RemoteMovie>)
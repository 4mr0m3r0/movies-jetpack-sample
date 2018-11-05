package com.tzion.remote.movie.model

import com.google.gson.annotations.SerializedName

class RemoteSearch(@SerializedName("Search") val search: List<RemoteMovie>)
package com.tzion.jetpackmovies.data.source

import javax.inject.Inject

class DataSourceFactory @Inject constructor(private val remote: Remote) {

    fun getRemote() = remote

}
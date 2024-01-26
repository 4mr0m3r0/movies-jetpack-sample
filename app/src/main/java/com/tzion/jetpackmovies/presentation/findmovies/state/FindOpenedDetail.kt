package com.tzion.jetpackmovies.presentation.findmovies.state

class FindOpenedDetail : FindState {
    companion object {
        private var instance: FindState? = null

        fun getInstance(): FindState = instance ?: synchronized(this) {
            FindOpenedDetail().also { instance = it }
        }
    }
}

package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {

    private val findMovieQueryLiveData = MutableLiveData<String>()

    fun getFindMovieQueryLiveData(): LiveData<String> = findMovieQueryLiveData

    fun postFindMovieQuery(name: String) {
        findMovieQueryLiveData.postValue(name)
    }

}
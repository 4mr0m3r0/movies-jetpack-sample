package com.tzion.presentation.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tzion.domain.movie.GetMoviesUseCase
import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.Resource
import com.tzion.presentation.ResourceState
import com.tzion.presentation.movie.model.MovieView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class DisplayMoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val mapper: MovieViewMapper)
    : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<MovieView>>> = MutableLiveData()

    override fun onCleared() {
        getMoviesUseCase.dispose()
        super.onCleared()
    }

    fun getMovies(): LiveData<Resource<List<MovieView>>> {
        return liveData
    }

    fun fetchMovies() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getMoviesUseCase.execute(MovieSubscriber())
    }

    inner class MovieSubscriber: DisposableObserver<List<Movie>>() {
        override fun onComplete() {
        }

        override fun onNext(t: List<Movie>) {
            Log.d("DisplayMoviesViewModel", "MovieSubscriber onNext")
            liveData.postValue(Resource(
                ResourceState.SUCCESS, t.map { mapper.mapToView(it) }, null
            ))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

}
package com.tzion.presentation.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tzion.domain.movie.FindMoviesUseCase
import com.tzion.domain.movie.model.Movie
import com.tzion.presentation.Resource
import com.tzion.presentation.ResourceState
import com.tzion.presentation.movie.model.MoviePresentation
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class FindMoviesViewModel @Inject constructor(
    private val findMoviesUseCase: FindMoviesUseCase,
    private val mapper: MoviePresentationMapper)
    : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<MoviePresentation>>> = MutableLiveData()

    override fun onCleared() {
        findMoviesUseCase.dispose()
        super.onCleared()
    }

    fun getMoviesLiveData(): LiveData<Resource<List<MoviePresentation>>> {
        return liveData
    }

    fun findMoviesByText(text: String?) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        findMoviesUseCase.execute(MovieSubscriber(), FindMoviesUseCase.Params(text))
    }

    inner class MovieSubscriber: DisposableSingleObserver<List<Movie>>() {
        override fun onSuccess(t: List<Movie>) {
            liveData.postValue(Resource(
                    ResourceState.SUCCESS, t.map { mapper.mapToPresentation(it) }, null
            ))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }

}
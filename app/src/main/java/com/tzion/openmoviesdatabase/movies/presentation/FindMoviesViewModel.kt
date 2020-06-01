package com.tzion.openmoviesdatabase.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.openmoviesdatabase.movies.domain.FindMoviesByNameUseCase
import com.tzion.openmoviesdatabase.movies.domain.exception.NoMoviesResultsException
import com.tzion.openmoviesdatabase.movies.presentation.mapper.UiMovieMapper
import com.tzion.openmoviesdatabase.movies.presentation.uistates.FindMoviesUiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class FindMoviesViewModel @Inject constructor(
    private val findMoviesUseCase: FindMoviesByNameUseCase,
    private val mapper: UiMovieMapper): ViewModel() {

    private val liveData: MutableLiveData<FindMoviesUiState> = MutableLiveData()

    fun getLiveData(): LiveData<FindMoviesUiState> = liveData

    fun findMoviesByName(name: String?) {
        viewModelScope.launch {
            try {
                liveData.value = FindMoviesUiState.Loading
                findMoviesUseCase
                    .findMovieByName(name)
                    .map { domainMovies ->
                        with(mapper) { domainMovies.fromDomainToUi() }
                    }
                    .collect { movies ->
                        if (movies.isNullOrEmpty()) {
                            liveData.value = FindMoviesUiState.Error(NoMoviesResultsException("No movies result"))
                        } else {
                            liveData.value = FindMoviesUiState.Success(movies)
                        }
                    }
            } catch (e: Throwable) {
                liveData.value = FindMoviesUiState.Error(e)
            }
        }

    }

}
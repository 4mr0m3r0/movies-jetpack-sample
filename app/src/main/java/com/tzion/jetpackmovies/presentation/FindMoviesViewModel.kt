package com.tzion.jetpackmovies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzion.jetpackmovies.domain.FindMoviesByNameUseCase
import com.tzion.jetpackmovies.domain.exception.NoMoviesResultsException
import com.tzion.jetpackmovies.presentation.mapper.UiMovieMapper
import com.tzion.jetpackmovies.presentation.uistates.FindMoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMoviesViewModel @Inject constructor(
    private val findMoviesUseCase: FindMoviesByNameUseCase,
    private val mapper: UiMovieMapper
) : ViewModel() {

    private val liveData: MutableLiveData<FindMoviesUiState> = MutableLiveData()

    fun getLiveData(): LiveData<FindMoviesUiState> = liveData

    fun findMoviesByName(name: String?) {
        viewModelScope.launch {
            liveData.value = FindMoviesUiState.LoadingUiSate
            findMoviesUseCase
                .findMovieByName(name)
                .map { domainMovies ->
                    with(mapper) { domainMovies.fromDomainToUi() }
                }
                .catch { cause ->
                    liveData.value = FindMoviesUiState.ErrorUiState(cause)
                }
                .collect { movies ->
                    if (movies.isNullOrEmpty()) {
                        liveData.value =
                            FindMoviesUiState.ErrorUiState(NoMoviesResultsException("No movies result"))
                    } else {
                        liveData.value = FindMoviesUiState.MoviesResultDisplayUiState(movies)
                    }
                }
        }
    }
}

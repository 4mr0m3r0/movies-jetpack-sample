package com.tzion.domain.movie

import com.tzion.domain.ObservableUseCase
import com.tzion.domain.executor.PostExecutionThread
import com.tzion.domain.movie.model.Movie
import io.reactivex.Observable
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    postExecutionThread: PostExecutionThread
)
    : ObservableUseCase<List<Movie>, Nothing?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Movie>> {
        return movieRepository.getMovies()
    }

}
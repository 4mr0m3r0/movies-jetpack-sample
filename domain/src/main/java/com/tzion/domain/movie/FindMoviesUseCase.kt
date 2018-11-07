package com.tzion.domain.movie

import com.tzion.domain.SingleUseCase
import com.tzion.domain.executor.PostExecutionThread
import com.tzion.domain.movie.model.Movie
import io.reactivex.Single
import javax.inject.Inject

open class FindMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    postExecutionThread: PostExecutionThread)
    : SingleUseCase<List<Movie>, FindMoviesUseCase.Params>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Params?): Single<List<Movie>> {
        return movieRepository.findMoviesByText(params?.text)
    }

    data class Params(val text: String?)

}
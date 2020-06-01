package com.tzion.openmoviesdatabase.movies.domain.repository

import androidx.lifecycle.LiveData
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovie
import com.tzion.openmoviesdatabase.movies.domain.model.DomainMovieDetail
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun findMoviesByName(name: String): Flow<List<DomainMovie>>

    fun getMovieDetailById(movieId: String): Flow<DomainMovieDetail>

}
package com.tzion.cache.movie

import com.tzion.cache.CacheMapper
import com.tzion.cache.movie.model.CachedMovie
import com.tzion.data.movie.model.MovieEntity
import javax.inject.Inject

open class CachedMovieMapper @Inject constructor(): CacheMapper<CachedMovie, MovieEntity> {

    override fun mapFromCached(cache: CachedMovie): MovieEntity {
        return MovieEntity(cache.id, cache.title, cache.year, cache.poster, cache.type)
    }

    override fun mapToCached(entity: MovieEntity): CachedMovie {
        return CachedMovie(
            entity.imdbID, entity.title, entity.year,
            "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", entity.type, "",
            "", "", "")
    }

}
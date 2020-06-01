package com.tzion.openmoviesdatabase.movies.data.mapper

import com.tzion.openmoviesdatabase.movies.factory.MovieDetailFactory.makeRemoteMovieDetail
import org.junit.Assert.*
import org.junit.Test

class DataMovieDetailMapperTest {

    private val mapper = DataMovieDetailMapper()

    @Test
    fun `given RemoteMovieDetail, when fromRemoteToDomain, then DomainMovieDetail`() {
        val remoteMovieDetail = makeRemoteMovieDetail()

        val domainMovieDetail = with(mapper) { remoteMovieDetail.fromRemoteToDomain() }

        assertEquals("title", remoteMovieDetail.title, domainMovieDetail.title)
        assertEquals("year", remoteMovieDetail.year, domainMovieDetail.year)
        assertEquals("rated", remoteMovieDetail.rated, domainMovieDetail.rated)
        assertEquals("released", remoteMovieDetail.released, domainMovieDetail.released)
        assertEquals("runtime", remoteMovieDetail.runtime, domainMovieDetail.runtime)
        assertEquals("genre", remoteMovieDetail.genre, domainMovieDetail.genre)
        assertEquals("director", remoteMovieDetail.director, domainMovieDetail.director)
        assertEquals("writer", remoteMovieDetail.writer, domainMovieDetail.writer)
        assertEquals("actors", remoteMovieDetail.actors, domainMovieDetail.actors)
        assertEquals("plot", remoteMovieDetail.plot, domainMovieDetail.plot)
        assertEquals("language", remoteMovieDetail.language, domainMovieDetail.language)
        assertEquals("country", remoteMovieDetail.country, domainMovieDetail.country)
        assertEquals("awards", remoteMovieDetail.awards, domainMovieDetail.awards)
        assertEquals("poster", remoteMovieDetail.poster, domainMovieDetail.poster)
        assertEquals("rating", remoteMovieDetail.rating, domainMovieDetail.rating)
        assertEquals("metascore", remoteMovieDetail.metascore, domainMovieDetail.metascore)
        assertEquals("imdbRating", remoteMovieDetail.imdbRating, domainMovieDetail.imdbRating)
        assertEquals("imdbVotes", remoteMovieDetail.imdbVotes, domainMovieDetail.imdbVotes)
        assertEquals("imdbId", remoteMovieDetail.imdbId, domainMovieDetail.imdbId)
        assertEquals("type", remoteMovieDetail.type, domainMovieDetail.type)
        assertEquals("dvd", remoteMovieDetail.dvd, domainMovieDetail.dvd)
        assertEquals("boxOffice", remoteMovieDetail.boxOffice, domainMovieDetail.boxOffice)
        assertEquals("production", remoteMovieDetail.production, domainMovieDetail.production)
        assertEquals("website", remoteMovieDetail.website, domainMovieDetail.website)
    }

}
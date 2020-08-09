package com.tzion.jetpackmovies.presentation.mapper

import com.tzion.jetpackmovies.factory.MovieDetailFactory.makeDomainMovieDetail
import org.junit.Assert.*
import org.junit.Test

class UiMovieDetailMapperTest {
    
    private val mapper = UiMovieDetailMapper()
    
    @Test
    fun `given DomainMovieDetail, when fromDomainToUi, then UiMovieDetail`() {
        val domainMovieDetail = makeDomainMovieDetail()
        
        val uiMovieDetail = with(mapper) { domainMovieDetail.fromDomainToUi() }

        assertEquals("title", domainMovieDetail.title, uiMovieDetail.title)
        assertEquals("year", domainMovieDetail.year, uiMovieDetail.year)
        assertEquals("released", domainMovieDetail.released, uiMovieDetail.released)
        assertEquals("runtime", domainMovieDetail.runtime, uiMovieDetail.runtime)
        assertEquals("genre", domainMovieDetail.genre, uiMovieDetail.genre)
        assertEquals("director", domainMovieDetail.director, uiMovieDetail.director)
        assertEquals("writer", domainMovieDetail.writer, uiMovieDetail.writer)
        assertEquals("actors", domainMovieDetail.actors, uiMovieDetail.actors)
        assertEquals("plot", domainMovieDetail.plot, uiMovieDetail.plot)
        assertEquals("language", domainMovieDetail.language, uiMovieDetail.language)
        assertEquals("country", domainMovieDetail.country, uiMovieDetail.country)
        assertEquals("awards", domainMovieDetail.awards, uiMovieDetail.awards)
        assertEquals("poster", domainMovieDetail.poster, uiMovieDetail.poster)
        assertEquals("rating", domainMovieDetail.rating, uiMovieDetail.rating)
        assertEquals("imdbRating", domainMovieDetail.imdbRating, uiMovieDetail.imdbRating)
        assertEquals("imdbVotes", domainMovieDetail.imdbVotes, uiMovieDetail.imdbVotes)
        assertEquals("type", domainMovieDetail.type, uiMovieDetail.type)
    }
    
}
package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.factory.MovieFavoriteRandom
import org.junit.Assert.assertEquals
import kotlin.test.Test

class DataFavoriteMapperTest {

    private val mapper = DataFavoriteMapper()

    @Test
    fun `given DataFavoriteMovie, when toFavorite, then Movie Favorite`() {
        val data = MovieFavoriteRandom.generateDataFavorite()

        val result = with(mapper) { data.toFavorite() }

        assertEquals("title", data.title, result.title)
        assertEquals("year", data.year, result.year)
        assertEquals("rated", data.rated, result.rated)
        assertEquals("released", data.released, result.released)
        assertEquals("runtime", data.runtime, result.runtime)
        assertEquals("genre", data.genre, result.genre)
        assertEquals("director", data.director, result.director)
        assertEquals("writer", data.writer, result.writer)
        assertEquals("actors", data.actors, result.actors)
        assertEquals("plot", data.plot, result.plot)
        assertEquals("language", data.language, result.language)
        assertEquals("country", data.country, result.country)
        assertEquals("awards", data.awards, result.awards)
        assertEquals("poster", data.poster, result.poster)
        assertEquals("metascore", data.metascore, result.metascore)
        assertEquals("type", data.type, result.type)
        assertEquals("dvd", data.dvd, result.dvd)
        assertEquals("boxOffice", data.boxOffice, result.boxOffice)
        assertEquals("production", data.production, result.production)
        assertEquals("website", data.website, result.website)
    }
}

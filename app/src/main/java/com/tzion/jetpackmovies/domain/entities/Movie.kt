package com.tzion.jetpackmovies.domain.entities

class Movie(private val tomatoMeter: TomatoMeter) {
    fun verifyTitleAndGetTrimValue(title: String?): String {
        require(!title.isNullOrEmpty())
        return title.trim()
    }

    fun updateWithTomatoMeter(information: Information): Information = information
        .copy(tomatoMeter = tomatoMeter.calculate(information.rating))

    data class Information(
        val title: String?,
        val year: String?,
        val rated: String?,
        val released: String?,
        val runtime: String?,
        val genre: String?,
        val director: String?,
        val writer: String?,
        val actors: String?,
        val plot: String?,
        val language: String?,
        val country: String?,
        val awards: String?,
        val image: String?,
        val metascore: String?,
        val rating: String?,
        val votes: String?,
        val type: String?,
        val dvd: String?,
        val boxOffice: String?,
        val production: String?,
        val website: String?,
        val tomatoMeter: TomatoMeter.State? = null
    )

    data class Poster(
        val movieId: String,
        val title: String,
        val year: String,
        val image: String,
        val type: String,
    )

    data class Favorite(
        val movieId: String,
        val title: String,
        val year: String,
        val genre: String,
        val poster: String,
    )
}
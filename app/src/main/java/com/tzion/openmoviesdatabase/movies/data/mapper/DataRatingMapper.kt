package com.tzion.openmoviesdatabase.movies.data.mapper

import com.tzion.openmoviesdatabase.movies.data.remote.model.RemoteRating
import com.tzion.openmoviesdatabase.movies.domain.model.DomainRating
import javax.inject.Inject

class DataRatingMapper @Inject constructor() {

    fun List<RemoteRating>.fromRemoteToDomain() = map { remoteRating ->
        remoteRating.fromRemoteToDomain()
    }

    fun RemoteRating.fromRemoteToDomain() = DomainRating(
        source = source,
        value = value
    )

}
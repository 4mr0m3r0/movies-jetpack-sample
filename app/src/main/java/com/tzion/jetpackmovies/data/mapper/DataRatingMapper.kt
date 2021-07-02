package com.tzion.jetpackmovies.data.mapper

import com.tzion.jetpackmovies.data.remote.model.RemoteRating
import com.tzion.jetpackmovies.domain.model.DomainRating
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

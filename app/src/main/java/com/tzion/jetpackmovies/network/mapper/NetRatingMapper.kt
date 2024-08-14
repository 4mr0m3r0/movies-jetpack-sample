package com.tzion.jetpackmovies.network.mapper

import com.tzion.jetpackmovies.domain.valueobj.DomainRating
import com.tzion.jetpackmovies.network.model.RemoteRating
import javax.inject.Inject

class NetRatingMapper @Inject constructor() {

    fun List<RemoteRating>.fromRemoteToDomain() = map { remoteRating ->
        remoteRating.fromRemoteToDomain()
    }

    fun RemoteRating.fromRemoteToDomain() = DomainRating(
        source = source,
        value = value
    )
}

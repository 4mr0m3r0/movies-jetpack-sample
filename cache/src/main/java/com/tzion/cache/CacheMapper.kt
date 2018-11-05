package com.tzion.cache

interface CacheMapper<C, E> {

    fun mapFromCached(cache: C): E

    fun mapToCached(entity: E): C

}
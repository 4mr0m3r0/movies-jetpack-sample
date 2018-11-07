package com.tzion.openmoviesdatabase

interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}
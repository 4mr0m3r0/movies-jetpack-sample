package com.tzion.openmoviesdatabase.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

object RandomFactory {

    fun generateString(): String {
        return UUID.randomUUID().toString()
    }

    fun generateInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

}
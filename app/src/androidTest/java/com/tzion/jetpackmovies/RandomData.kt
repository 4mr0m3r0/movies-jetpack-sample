package com.tzion.jetpackmovies

import java.util.UUID
import java.util.concurrent.ThreadLocalRandom

object RandomData {

    fun generateString(): String {
        return UUID.randomUUID().toString()
    }

    fun generateInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }
}

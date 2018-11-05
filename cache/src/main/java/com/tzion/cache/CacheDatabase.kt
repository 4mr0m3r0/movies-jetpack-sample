package com.tzion.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tzion.cache.config.ConfigDao
import com.tzion.cache.config.model.Config
import com.tzion.cache.movie.CachedMovieDao
import com.tzion.cache.movie.model.CachedMovie
import javax.inject.Inject

@Database(entities = [CachedMovie::class, Config::class], version = 1)
abstract class CacheDatabase  @Inject constructor(): RoomDatabase() {

    abstract fun cachedMovieDao(): CachedMovieDao

    abstract fun configDao(): ConfigDao

    companion object {
        private var INSTANCE: CacheDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): CacheDatabase {
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CacheDatabase::class.java, "movies.db")
                            .build()
                    }
                    return INSTANCE as CacheDatabase
                }
            }
            return INSTANCE as CacheDatabase
        }
    }

}
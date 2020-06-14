package com.tzion.jetpackmovies.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tzion.jetpackmovies.data.cache.model.CacheMovieDetail

@Database(version = 1, entities = [CacheMovieDetail::class], exportSchema = false)
abstract class DatabaseBuilder: RoomDatabase() {

    abstract fun favoriteMovieDao(): FavoriteMovieDao

    companion object {
        @Volatile private var INSTANCE: DatabaseBuilder? = null

        fun getInstance(context: Context): DatabaseBuilder = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context): DatabaseBuilder = Room
            .databaseBuilder(context.applicationContext, DatabaseBuilder::class.java, DatabaseConfigs.Names.DATABASE)
//            .addMigrations(MIGRATION_1_TO_2) //TODO: only when we need a migration
            .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(DatabaseConfigs.Queries.MIGRATION_ALTER_TABLE)
            }
        }
    }

}
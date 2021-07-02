package com.tzion.jetpackmovies.data.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tzion.jetpackmovies.data.cache.model.CacheFavoriteMovie

@Database(version = 1, entities = [CacheFavoriteMovie::class], exportSchema = false)
abstract class DatabaseBuilder: RoomDatabase() {

    abstract fun favoriteMovieDao(): FavoriteMovieDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseBuilder? = null

        fun getInstance(context: Context): DatabaseBuilder = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context)
        }

        /**
         * For a migration we could add
         * .addMigrations(MIGRATION_1_TO_2)
         * And this would be MIGRATION_1_TO_2
         * private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
         *   override fun migrate(database: SupportSQLiteDatabase) {
         *      database.execSQL(DatabaseConfigs.Queries.MIGRATION_ALTER_TABLE)
         *   }
         * }
         */
        private fun buildDatabase(context: Context): DatabaseBuilder = Room
            .databaseBuilder(
                context.applicationContext,
                DatabaseBuilder::class.java,
                DatabaseConfigs.Names.DATABASE
            )
            .build()
    }
}

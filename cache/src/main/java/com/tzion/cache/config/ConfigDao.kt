package com.tzion.cache.config

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tzion.cache.config.ConfigConstants.SELECT_CONFIG
import com.tzion.cache.config.model.Config
import io.reactivex.Single

@Dao
abstract class ConfigDao {

    @Query(SELECT_CONFIG)
    abstract fun getConfig(): Single<Config>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: Config)

}
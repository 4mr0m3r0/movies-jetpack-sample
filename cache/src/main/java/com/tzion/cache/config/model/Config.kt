package com.tzion.cache.config.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tzion.cache.config.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
data class Config (@PrimaryKey(autoGenerate = true)
                          var id: Int = -1,
                   val lastCacheTime: Long)
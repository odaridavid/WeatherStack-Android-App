package com.github.odaridavid.wingu.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrentWeatherEntity::class], version = 1, exportSchema = false)
internal abstract class WinguDatabase : RoomDatabase() {

    abstract fun getForecastsDao(): ForecastsDao

    companion object {
        const val DATABASE_NAME = "wingu_database"
    }
}

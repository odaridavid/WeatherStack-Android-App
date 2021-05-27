package com.github.odaridavid.wingu.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.odaridavid.wingu.db.models.CurrentWeatherEntity
import com.github.odaridavid.wingu.db.models.WeatherForecastEntity

@Database(entities = [CurrentWeatherEntity::class,WeatherForecastEntity::class], version = 1, exportSchema = false)
internal abstract class WinguDatabase : RoomDatabase() {

    abstract fun getForecastsDao(): WeatherDao

    companion object {
        const val DATABASE_NAME = "wingu_database"
    }
}

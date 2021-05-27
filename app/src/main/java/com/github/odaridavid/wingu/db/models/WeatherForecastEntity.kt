package com.github.odaridavid.wingu.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_forecast")
data class WeatherForecastEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    //TODO Use a data object and the type converter business
    val date: String
)

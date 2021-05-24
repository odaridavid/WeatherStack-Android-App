package com.github.odaridavid.wingu.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_weather")
data class CurrentWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

package com.github.odaridavid.wingu.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface WeatherDao {

    // TODO Implement Dao Queries
    @Query("")
    fun getCurrentWeather()

    @Insert
    fun saveCurrentWeather()

    @Query("")
    fun getWeatherForecast()

    @Insert
    fun saveWeatherForecast()

}

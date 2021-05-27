package com.github.odaridavid.wingu.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.odaridavid.wingu.db.models.CurrentWeatherEntity
import com.github.odaridavid.wingu.db.models.WeatherForecastEntity

@Dao
internal interface WeatherDao {

    @Query("SELECT * FROM current_weather LIMIT 1")
    fun getCurrentWeather(): CurrentWeatherEntity

    @Insert
    fun saveCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("SELECT * FROM weather_forecast WHERE date=:date")
    fun getWeatherForecast(date: String): List<WeatherForecastEntity>

    @Insert
    fun saveWeatherForecast(vararg weatherForecastEntity: WeatherForecastEntity)

}

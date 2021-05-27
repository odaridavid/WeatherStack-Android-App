package com.github.odaridavid.wingu.features.weather.domain

import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow

internal interface WeatherRepository {

    suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>>

    suspend fun getWeatherForecast(location: String): Flow<Result<WeatherForecast>>
}

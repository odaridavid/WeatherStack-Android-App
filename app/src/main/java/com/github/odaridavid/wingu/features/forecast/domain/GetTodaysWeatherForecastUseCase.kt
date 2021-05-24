package com.github.odaridavid.wingu.features.forecast.domain

import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow

internal class GetTodaysWeatherForecastUseCase(
    private val forecastsRepository: ForecastsRepository
) {
    suspend fun execute(location: String): Flow<Result<CurrentWeather>> =
        forecastsRepository.getCurrentWeather(location = location)
}

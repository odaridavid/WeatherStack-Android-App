package com.github.odaridavid.wingu.features.weather.domain.usecases

import com.github.odaridavid.wingu.features.weather.domain.WeatherRepository
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow

internal class GetWeatherForecastUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(location: String): Flow<Result<WeatherForecast>> =
        weatherRepository.getWeatherForecast(location = location)

}

package com.github.odaridavid.wingu.features.forecast.data.mappers

import com.github.odaridavid.wingu.api.models.CurrentWeatherApiResponse
import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather

internal class ApiToDomainMapper {

    fun toDomainModel(currentWeatherApiResponse: CurrentWeatherApiResponse): CurrentWeather =
        CurrentWeather(
            location = currentWeatherApiResponse.location.name,
            temperature = "${currentWeatherApiResponse.current.temperature}",
            weatherDescriptions = currentWeatherApiResponse.current.weatherDescriptions,
            weatherIcons = currentWeatherApiResponse.current.weatherIcons,
            temperatureFeelsLike = "Feels like ${currentWeatherApiResponse.current.feelsLike}"
        )

}

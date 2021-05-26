package com.github.odaridavid.wingu.features.forecast.data.mappers

import com.github.odaridavid.wingu.api.models.CurrentWeatherResponse
import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather

internal object ApiToDomainMapper {

    fun toDomainModel(currentWeatherResponse: CurrentWeatherResponse): CurrentWeather =
        CurrentWeather(
            location = currentWeatherResponse.location.name,
            temperature = "${currentWeatherResponse.current.temperature}",
            weatherDescriptions = currentWeatherResponse.current.weatherDescriptions,
            weatherIcons = currentWeatherResponse.current.weatherIcons,
            temperatureFeelsLike = "Feels like ${currentWeatherResponse.current.feelsLike}"
        )

}

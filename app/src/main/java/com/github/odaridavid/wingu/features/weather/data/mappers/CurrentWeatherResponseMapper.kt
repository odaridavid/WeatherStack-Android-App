package com.github.odaridavid.wingu.features.weather.data.mappers

import com.github.odaridavid.wingu.api.models.CurrentWeatherResponse
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather

internal object CurrentWeatherResponseMapper {

    fun toDomainModel(currentWeatherResponse: CurrentWeatherResponse): CurrentWeather =
        CurrentWeather(
            location = currentWeatherResponse.location.name,
            temperature = "${currentWeatherResponse.current.temperature}",
            weatherDescriptions = currentWeatherResponse.current.weatherDescriptions,
            weatherIcons = currentWeatherResponse.current.weatherIcons,
            temperatureFeelsLike = "Feels like ${currentWeatherResponse.current.feelsLike}"
        )

}

package com.github.odaridavid.wingu.features.weather.data.mappers

import com.github.odaridavid.wingu.api.models.CurrentWeatherResponse
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.shared.DomainMapper

internal object CurrentWeatherResponseMapper : DomainMapper<CurrentWeatherResponse, CurrentWeather> {

    override fun map(response: CurrentWeatherResponse): CurrentWeather =
        CurrentWeather(
            location = response.location.name,
            temperature = "${response.current.temperature}",
            weatherDescriptions = response.current.weatherDescriptions,
            weatherIcons = response.current.weatherIcons,
            temperatureFeelsLike = "Feels like ${response.current.feelsLike}"
        )

}

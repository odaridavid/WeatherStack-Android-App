package com.github.odaridavid.wingu.features.weather.domain.models

internal data class CurrentWeather(
    val location: String,
    val temperature: String,
    val temperatureFeelsLike: String,
    val weatherIcons: List<String>,
    val weatherDescriptions: List<String>
)

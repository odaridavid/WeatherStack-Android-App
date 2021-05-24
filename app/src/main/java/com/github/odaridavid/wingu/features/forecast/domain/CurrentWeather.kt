package com.github.odaridavid.wingu.features.forecast.domain

internal data class CurrentWeather(
    val location: String,
    val temperature: String,
    val temperatureFeelsLike: String,
    val weatherIcons: List<String>,
    val weatherDescriptions: List<String>
)

package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json

data class CurrentWeatherInfo(
    val temperature: Int,
    @Json(name = "weather_icons") val weatherIcons: List<String>,
    @Json(name = "weather_descriptions") val weatherDescriptions: List<String>,
    @Json(name = "feelslike") val feelsLike: Int,
)

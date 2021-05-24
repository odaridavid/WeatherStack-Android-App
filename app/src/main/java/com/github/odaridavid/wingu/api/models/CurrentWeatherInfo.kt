package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherInfo(
    val temperature: Int,
    @field:Json(name = "weather_icons") val weatherIcons: List<String>,
    @field:Json(name = "weather_descriptions") val weatherDescriptions: List<String>,
    @field:Json(name = "feelslike") val feelsLike: Int,
)

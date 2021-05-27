package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastInfo(
    val date: String,
    @field:Json(name = "mintemp") val minTemp: Int,
    @field:Json(name = "maxtemp") val maxTemp: Int
)

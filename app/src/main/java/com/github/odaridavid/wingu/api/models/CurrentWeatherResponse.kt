package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    val request: RequestInfo,
    val location: LocationInfo,
    val current: CurrentWeatherInfo,
    @field:Json(name = "success") val isSuccess: Boolean? = null,
    @field:Json(name = "error") val errorResponse: ApiErrorResponse? = null
)

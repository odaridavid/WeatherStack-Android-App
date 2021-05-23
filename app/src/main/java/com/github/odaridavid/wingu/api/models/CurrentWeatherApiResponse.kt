package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json

data class CurrentWeatherApiResponse(
    val request: RequestInfo,
    val location: LocationInfo,
    val current: CurrentWeatherInfo,
    @Json(name = "success") val isSuccess: Boolean? = null,
    @Json(name = "error") val errorResponse: ApiErrorResponse? = null
)

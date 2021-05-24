package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationInfo(
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    @field:Json(name = "timezone_id") val timezoneId: String,
    @field:Json(name = "localtime") val localTime: String,
    @field:Json(name = "localtime_epoch") val localTimeEpoch: Long,
    @field:Json(name = "utc_offset")val utcOffset: String
)

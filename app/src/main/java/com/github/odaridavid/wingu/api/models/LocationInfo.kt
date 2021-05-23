package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.Json

data class LocationInfo(
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    @Json(name = "timezone_id") val timezoneId: String,
    val localTime: String,
    @Json(name = "localtime_epoch") val localTimeEpoch: Long,
    val utcOffset: String
)

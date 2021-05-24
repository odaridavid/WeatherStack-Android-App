package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestInfo(
    val language: String,
    val unit: String
)

package com.github.odaridavid.wingu.api.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiErrorResponse(
    val code: Int?,
    val type: String?,
    val info: String?
)

package com.github.odaridavid.wingu.api.models

data class ApiErrorResponse(
    val code: Int?,
    val type: String?,
    val info: String?
)

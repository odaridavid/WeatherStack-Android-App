package com.github.odaridavid.wingu.api.utils

import com.github.odaridavid.wingu.api.models.ApiErrorResponse

internal object ApiErrorHandler {

    fun getUserFriendlyErrorMessage(apiErrorResponse: ApiErrorResponse): String =
        when (apiErrorResponse.code) {
            in 101..105 -> "An error occured with your user account"
            in 601..615 -> "An error occured while making your request"
            else -> apiErrorResponse.info ?: "Oops something went wrong"
        }

}

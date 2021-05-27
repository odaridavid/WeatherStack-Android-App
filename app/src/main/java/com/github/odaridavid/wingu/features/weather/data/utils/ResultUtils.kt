package com.github.odaridavid.wingu.features.weather.data.utils

import com.github.odaridavid.wingu.api.models.ApiErrorResponse
import com.github.odaridavid.wingu.api.utils.ApiErrorHandler
import com.github.odaridavid.wingu.shared.DomainMapper
import com.github.odaridavid.wingu.shared.Result

internal fun <T> provideErrorResult(
    response: ApiErrorResponse? = null,
    message: String? = null
): Result.Error<T> =
    if (response != null) {
        Result.Error(
            message = ApiErrorHandler.getUserFriendlyErrorMessage(
                apiErrorResponse = response
            )
        )
    } else {
        Result.Error(message = message ?: "Could not fetch current weather")
    }

internal fun <Response, Domain> provideMappedSuccessResult(
    response: Response,
    mapper: DomainMapper<Response, Domain>
) = Result.Success(data = mapper.map(response = response))

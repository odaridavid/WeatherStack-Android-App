package com.github.odaridavid.wingu.api

import com.github.odaridavid.wingu.api.models.ApiErrorResponse
import com.github.odaridavid.wingu.api.utils.ApiErrorHandler
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ApiErrorHandlerTest {

    companion object {
        @JvmStatic
        @Suppress("Unused")
         fun errorResponseParserParams(): Stream<Arguments> = Stream.of(
            arguments(
                ApiErrorResponse(code = 234, info = null, type = ""),
                "Oops something went wrong"
            ),
            arguments(ApiErrorResponse(code = 234, info = "Error", type = ""), "Error"),
            arguments(
                ApiErrorResponse(code = 104, info = null, type = ""),
                "An error occured with your user account"
            ),
            arguments(
                ApiErrorResponse(code = 604, info = null, type = ""),
                "An error occured while making your request"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("errorResponseParserParams")
    fun `when we get an error response and parse it, then the correct user friendly message is returned`(
        apiErrorResponse: ApiErrorResponse,
        expectedResult: String
    ) {
        // when we parse the error response
        val result =
            ApiErrorHandler.getUserFriendlyErrorMessage(apiErrorResponse = apiErrorResponse)

        // then we get the correct user friendly message
        assert(result == expectedResult)

    }

}

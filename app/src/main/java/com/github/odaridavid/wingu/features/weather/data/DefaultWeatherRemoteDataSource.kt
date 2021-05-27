package com.github.odaridavid.wingu.features.weather.data

import com.github.odaridavid.wingu.api.WeatherStackApiService
import com.github.odaridavid.wingu.api.models.ApiErrorResponse
import com.github.odaridavid.wingu.api.models.CurrentWeatherResponse
import com.github.odaridavid.wingu.api.utils.ApiErrorHandler
import com.github.odaridavid.wingu.features.weather.data.mappers.CurrentWeatherResponseMapper
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DefaultWeatherRemoteDataSource(
    private val apiService: WeatherStackApiService
) : WeatherRemoteDataSource {

    // region ForecastsRemoteDataSource

    override suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>> {
        val apiRequest = apiService.getCurrentWeather(location = location)
        val response: CurrentWeatherResponse? = apiRequest.body()
        return flow {
            if (apiRequest.isSuccessful && response != null) {
                if (response.isSuccess == null || response.isSuccess == true) {
                    emit(provideSuccessResult(response = response))
                } else {
                    emit(provideErrorResult(response = response.errorResponse))
                }
            } else {
                emit(
                    provideErrorResult(message = apiRequest.message())
                )
            }
        }
    }

    override suspend fun getWeatherForecast(location: String): Flow<Result<WeatherForecast>> {
        TODO("Not yet implemented")
    }

    // endregion

    // region Private Api

    private fun provideErrorResult(
        response: ApiErrorResponse? = null,
        message: String? = null
    ): Result.Error<CurrentWeather> =
        if (response != null) {
            Result.Error(
                message = ApiErrorHandler.getUserFriendlyErrorMessage(
                    apiErrorResponse = response
                )
            )
        } else {
            Result.Error(message = message ?: "Could not fetch current weather")
        }

    private fun provideSuccessResult(response: CurrentWeatherResponse) =
        Result.Success(
            data = CurrentWeatherResponseMapper.toDomainModel(
                currentWeatherResponse = response
            )
        )

    // endregion
}

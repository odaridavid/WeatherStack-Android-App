package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.api.WeatherStackApiService
import com.github.odaridavid.wingu.api.models.CurrentWeatherApiResponse
import com.github.odaridavid.wingu.features.forecast.data.mappers.ApiToDomainMapper
import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DefaultForecastsRemoteDataSource(
    private val apiService: WeatherStackApiService,
    private val apiToDomainMapper: ApiToDomainMapper
) : ForecastsRemoteDataSource {

    override suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>> {
        val apiRequest = apiService.getCurrentWeather(location = location)
        val response: CurrentWeatherApiResponse? = apiRequest.body()
        return flow {
            if (apiRequest.isSuccessful && response != null) {
                if (response.isSuccess == true) {
                    emit(
                        Result.Success<CurrentWeather>(
                            data = apiToDomainMapper.toDomainModel(
                                currentWeatherApiResponse = response
                            )
                        )
                    )
                } else {
                    // TODO Work on error handling
                    emit(Result.Error<CurrentWeather>(message = response.errorResponse?.info))
                }
            } else {
                emit(
                    Result.Error<CurrentWeather>(
                        message = apiRequest.message() ?: "Could not fetch current weather"
                    )
                )
            }
        }
    }


}

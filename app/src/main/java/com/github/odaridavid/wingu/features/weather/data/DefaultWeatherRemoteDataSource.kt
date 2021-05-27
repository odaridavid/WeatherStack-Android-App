package com.github.odaridavid.wingu.features.weather.data

import com.github.odaridavid.wingu.api.WeatherStackApiService
import com.github.odaridavid.wingu.api.models.CurrentWeatherResponse
import com.github.odaridavid.wingu.api.models.WeatherForecastResponse
import com.github.odaridavid.wingu.features.weather.data.mappers.CurrentWeatherResponseMapper
import com.github.odaridavid.wingu.features.weather.data.mappers.WeatherForecastResponseMapper
import com.github.odaridavid.wingu.features.weather.data.utils.provideErrorResult
import com.github.odaridavid.wingu.features.weather.data.utils.provideMappedSuccessResult
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
                    emit(
                        provideMappedSuccessResult(
                            response = response,
                            mapper = CurrentWeatherResponseMapper
                        )
                    )
                } else {
                    emit(provideErrorResult<CurrentWeather>(response = response.errorResponse))
                }
            } else {
                emit(
                    provideErrorResult<CurrentWeather>(message = apiRequest.message())
                )
            }
        }
    }

    override suspend fun getWeatherForecast(location: String): Flow<Result<WeatherForecast>> {
        val apiRequest = apiService.getWeatherForecast(location = location)
        val response: WeatherForecastResponse? = apiRequest.body()
        return flow {
            if (apiRequest.isSuccessful && response != null) {
                if (response.isSuccess == null || response.isSuccess == true) {
                    emit(
                        provideMappedSuccessResult(
                            response = response,
                            mapper = WeatherForecastResponseMapper
                        )
                    )
                } else {
                    emit(provideErrorResult<WeatherForecast>(response = response.errorResponse))
                }
            } else {
                emit(
                    provideErrorResult<WeatherForecast>(message = apiRequest.message())
                )
            }
        }
    }

    // endregion
}

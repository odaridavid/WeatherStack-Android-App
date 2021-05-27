package com.github.odaridavid.wingu.features.weather.data

import com.github.odaridavid.wingu.features.weather.domain.WeatherRepository
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

internal class DefaultWeatherRepository constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val localDataSource: WeatherLocalDataSource
) : WeatherRepository {

    //TODO check local cache first before remote
    override suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>> =
        remoteDataSource.getCurrentWeather(location = location)
            .catch { throwable ->
                emit(Result.Error(throwable = throwable))
            }

    override suspend fun getWeatherForecast(location: String): Flow<Result<WeatherForecast>> {
        TODO("Not yet implemented")
    }

}

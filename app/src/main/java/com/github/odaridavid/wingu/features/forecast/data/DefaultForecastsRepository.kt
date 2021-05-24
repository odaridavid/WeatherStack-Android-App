package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather
import com.github.odaridavid.wingu.features.forecast.domain.ForecastsRepository
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

internal class DefaultForecastsRepository(
    private val remoteDataSource: ForecastsRemoteDataSource,
    private val localDataSource: ForecastsLocalDataSource
) : ForecastsRepository {

    //TODO Implement local cache
    override suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>> =
        remoteDataSource.getCurrentWeather(location = location)
            .catch { throwable ->
                emit(Result.Error(throwable = throwable))
            }

}

package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.features.forecast.domain.ForecastsRepository

internal class DefaultForecastsRepository(
    private val remoteDataSource: ForecastsRemoteDataSource,
    private val localDataSource: ForecastsLocalDataSource
) : ForecastsRepository {
}

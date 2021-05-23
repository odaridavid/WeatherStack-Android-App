package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.db.ForecastsDao

internal class DefaultForecastsLocalDataSource(
    private val forecastsDao: ForecastsDao
) : ForecastsLocalDataSource {
}

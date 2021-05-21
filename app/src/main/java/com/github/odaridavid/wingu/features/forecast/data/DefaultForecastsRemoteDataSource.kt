package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.api.WeatherStackApiService

internal class DefaultForecastsRemoteDataSource(
    private val apiService: WeatherStackApiService
) : ForecastsRemoteDataSource {
}

package com.github.odaridavid.wingu.features.forecast.data

import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow

internal interface ForecastsRemoteDataSource {

    suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>>
}

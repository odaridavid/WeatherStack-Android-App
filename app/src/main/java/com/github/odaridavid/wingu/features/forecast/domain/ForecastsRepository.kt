package com.github.odaridavid.wingu.features.forecast.domain

import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.Flow

internal interface ForecastsRepository {

    suspend fun getCurrentWeather(location: String): Flow<Result<CurrentWeather>>
}

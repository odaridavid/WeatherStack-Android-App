package com.github.odaridavid.wingu.features.weather.data.mappers

import com.github.odaridavid.wingu.api.models.WeatherForecastResponse
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast

internal object WeatherForecastResponseMapper {

    fun toDomainModel(weatherForecastResponse: WeatherForecastResponse): WeatherForecast {
        //TODO Map Values from response to domain
        return WeatherForecast()
    }
}

package com.github.odaridavid.wingu.features.weather.data.mappers

import com.github.odaridavid.wingu.api.models.WeatherForecastResponse
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.shared.DomainMapper

internal object WeatherForecastResponseMapper :
    DomainMapper<WeatherForecastResponse, WeatherForecast> {

    override fun map(response: WeatherForecastResponse): WeatherForecast {
        //TODO Work on multiple forecasts though it requires subscription to the API
        val tomorrowsDate = response.forecast.keys.first()
        return WeatherForecast(
            minTemp = response.forecast[tomorrowsDate]?.minTemp.toString() ?: "",
            maxTemp =  response.forecast[tomorrowsDate]?.maxTemp.toString() ?: "",
            date = tomorrowsDate
        )
    }
}

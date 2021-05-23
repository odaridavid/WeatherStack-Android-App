package com.github.odaridavid.wingu.api

import com.github.odaridavid.wingu.BuildConfig
import com.github.odaridavid.wingu.api.models.CurrentWeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherStackApiService {

    @GET("/current")
    suspend fun getCurrentWeather(
        @Query("access_key") accessKey: String = BuildConfig.WEATHERSTACK_ACCESS_KEY,
        @Query("query") location: String
    ): Response<CurrentWeatherApiResponse>

}

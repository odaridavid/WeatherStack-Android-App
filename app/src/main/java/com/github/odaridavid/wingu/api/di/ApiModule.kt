package com.github.odaridavid.wingu.api.di

import com.github.odaridavid.wingu.BuildConfig
import com.github.odaridavid.wingu.api.WEATHERSTACK_BASE_URL
import com.github.odaridavid.wingu.api.WeatherStackApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {

    single { provideWeatherStackApiService(retrofit = get()) }

    single { provideRetrofit(okHttpClient = get()) }

    single { provideOkHttp() }

}

private fun provideWeatherStackApiService(retrofit: Retrofit): WeatherStackApiService =
    retrofit.create(WeatherStackApiService::class.java)


private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(WEATHERSTACK_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

private fun provideOkHttp(): OkHttpClient {
    val okHttp = OkHttpClient()
        .newBuilder()
        .retryOnConnectionFailure(true)

    if (BuildConfig.DEBUG) {
        okHttp.addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
    }
    return okHttp.build()
}

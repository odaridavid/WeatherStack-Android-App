package com.github.odaridavid.wingu.features.forecast.di

import com.github.odaridavid.wingu.api.WeatherStackApiService
import com.github.odaridavid.wingu.features.forecast.data.*
import com.github.odaridavid.wingu.features.forecast.domain.ForecastsRepository
import com.github.odaridavid.wingu.features.forecast.domain.GetTodaysWeatherForecastUseCase
import com.github.odaridavid.wingu.features.forecast.ui.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val forecastFeatureModule = module {

    single { provideForecastsLocalDataSource() }

    single { provideForecastsRemoteDataSource(weatherStackApiService = get()) }

    single {
        provideForecastsRepository(
            forecastsLocalDataSource = get(),
            forecastsRemoteDataSource = get()
        )
    }

    single { provideGetTodaysWeatherForecastUseCase(forecastsRepository = get()) }

    viewModel { ForecastViewModel(getTodaysWeatherForecastUseCase = get()) }

}

private fun provideForecastsLocalDataSource(): ForecastsLocalDataSource =
    DefaultForecastsLocalDataSource()

private fun provideForecastsRemoteDataSource(
    weatherStackApiService: WeatherStackApiService
): ForecastsRemoteDataSource =
    DefaultForecastsRemoteDataSource(apiService = weatherStackApiService)

private fun provideForecastsRepository(
    forecastsLocalDataSource: ForecastsLocalDataSource,
    forecastsRemoteDataSource: ForecastsRemoteDataSource
): ForecastsRepository =
    DefaultForecastsRepository(
        localDataSource = forecastsLocalDataSource,
        remoteDataSource = forecastsRemoteDataSource
    )

private fun provideGetTodaysWeatherForecastUseCase(
    forecastsRepository: ForecastsRepository
): GetTodaysWeatherForecastUseCase =
    GetTodaysWeatherForecastUseCase(forecastsRepository = forecastsRepository)

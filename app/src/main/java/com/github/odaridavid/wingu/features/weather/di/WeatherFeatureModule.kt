package com.github.odaridavid.wingu.features.weather.di

import com.github.odaridavid.wingu.api.WeatherStackApiService
import com.github.odaridavid.wingu.features.weather.data.*
import com.github.odaridavid.wingu.features.weather.domain.WeatherRepository
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetCurrentWeatherUseCase
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetWeatherForecastUseCase
import com.github.odaridavid.wingu.features.weather.ui.CurrentWeatherViewModel
import com.github.odaridavid.wingu.features.weather.ui.TomorrowsWeatherForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherFeatureModule = module {

    single { provideForecastsLocalDataSource() }

    single { provideForecastsRemoteDataSource(weatherStackApiService = get()) }

    single {
        provideForecastsRepository(
            weatherLocalDataSource = get(),
            weatherRemoteDataSource = get()
        )
    }

    single { provideGetCurrentWeatherUseCase(weatherRepository = get()) }

    single { provideGetWeatherForecastUseCase(weatherRepository = get()) }

    viewModel {
        CurrentWeatherViewModel(
            getCurrentWeatherUseCase = get()
        )
    }

    viewModel {
        TomorrowsWeatherForecastViewModel(
            getWeatherForecastUseCase = get()
        )
    }

}

private fun provideForecastsLocalDataSource(): WeatherLocalDataSource =
    DefaultWeatherLocalDataSource()

private fun provideForecastsRemoteDataSource(
    weatherStackApiService: WeatherStackApiService
): WeatherRemoteDataSource =
    DefaultWeatherRemoteDataSource(apiService = weatherStackApiService)

private fun provideForecastsRepository(
    weatherLocalDataSource: WeatherLocalDataSource,
    weatherRemoteDataSource: WeatherRemoteDataSource
): WeatherRepository =
    DefaultWeatherRepository(
        localDataSource = weatherLocalDataSource,
        remoteDataSource = weatherRemoteDataSource
    )

private fun provideGetCurrentWeatherUseCase(
    weatherRepository: WeatherRepository
): GetCurrentWeatherUseCase =
    GetCurrentWeatherUseCase(weatherRepository = weatherRepository)

private fun provideGetWeatherForecastUseCase(
    weatherRepository: WeatherRepository
): GetWeatherForecastUseCase = GetWeatherForecastUseCase(weatherRepository = weatherRepository)

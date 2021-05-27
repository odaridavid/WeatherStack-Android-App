package com.github.odaridavid.wingu.features.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.odaridavid.wingu.features.weather.domain.models.WeatherForecast
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetWeatherForecastUseCase
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class TomorrowsWeatherViewModel(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase
) : ViewModel() {

    // region Members

    private val _weatherForecast = MutableStateFlow(Result.Success(data = WeatherForecast()))
    val weatherForecast: StateFlow<Result.Success<WeatherForecast>> = _weatherForecast
    private val _weatherForecastError = MutableStateFlow(Result.Error<WeatherForecast>())
    val weatherForecastError: StateFlow<Result.Error<WeatherForecast>> = _weatherForecastError

    // endregion

    // region Public Api

    fun getWeatherForecast(location: String) {
        viewModelScope.launch {
            getWeatherForecastUseCase.execute(location = location)
                .collect { weatherForecastResult ->
                    when (weatherForecastResult) {
                        is Result.Success<WeatherForecast> -> {
                            _weatherForecast.value = weatherForecastResult
                        }
                        is Result.Error<WeatherForecast> -> {
                            _weatherForecastError.value = weatherForecastResult
                        }
                    }
                }
        }
    }

    // endregion
}

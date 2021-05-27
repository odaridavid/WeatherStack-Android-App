package com.github.odaridavid.wingu.features.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetCurrentWeatherUseCase
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetWeatherForecastUseCase
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class WeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase
) : ViewModel() {

    private val _currentWeather = MutableStateFlow(
        Result.Success(
            data = CurrentWeather(
                location = "",
                weatherIcons = emptyList(),
                weatherDescriptions = emptyList(),
                temperatureFeelsLike = "",
                temperature = "0"
            )
        )
    )
    val currentWeather: StateFlow<Result.Success<CurrentWeather>> = _currentWeather

    private val _currentWeatherError = MutableStateFlow(Result.Error<CurrentWeather>())
    val currentWeatherError: StateFlow<Result.Error<CurrentWeather>> = _currentWeatherError

    init {
        viewModelScope.launch {
            //TODO Input location from view
            getCurrentWeatherUseCase.execute(location = "New York")
                .collect { currentWeatherResult ->
                    when (currentWeatherResult) {
                        is Result.Success<CurrentWeather> -> {
                            _currentWeather.value = currentWeatherResult
                        }
                        is Result.Error<CurrentWeather> -> {
                            _currentWeatherError.value = currentWeatherResult
                        }
                    }
                }
        }
    }

}

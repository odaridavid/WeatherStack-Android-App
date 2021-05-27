package com.github.odaridavid.wingu.features.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.odaridavid.wingu.features.weather.domain.models.CurrentWeather
import com.github.odaridavid.wingu.features.weather.domain.usecases.GetCurrentWeatherUseCase
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class CurrentWeatherViewModel(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    // region Members

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

    // endregion

    // region Public Api

    //TODO Fire this function when some action occurs in the view
    fun getCurrentWeather(location: String) {
        viewModelScope.launch {
            getCurrentWeatherUseCase.execute(location = location)
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

    // endregion
}

package com.github.odaridavid.wingu.features.forecast.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.odaridavid.wingu.features.forecast.domain.CurrentWeather
import com.github.odaridavid.wingu.features.forecast.domain.GetCurrentWeatherForecastUseCase
import com.github.odaridavid.wingu.shared.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

internal class ForecastViewModel(
    private val getCurrentWeatherForecastUseCase: GetCurrentWeatherForecastUseCase
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
            getCurrentWeatherForecastUseCase.execute(location = "New York")
                .collect { currentWeatherResult ->
                    when(currentWeatherResult){
                        is Result.Success<CurrentWeather> -> {
                            Log.d("Response:S","${currentWeatherResult.data}")
                            _currentWeather.value = currentWeatherResult
                        }
                        is Result.Error<CurrentWeather> ->{
                            _currentWeatherError.value = currentWeatherResult
                        }
                    }
                }
        }
    }

}

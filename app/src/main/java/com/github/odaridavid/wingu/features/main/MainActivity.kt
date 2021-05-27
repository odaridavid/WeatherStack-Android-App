package com.github.odaridavid.wingu.features.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.odaridavid.wingu.databinding.ActivityMainBinding
import com.github.odaridavid.wingu.features.weather.ui.WeatherViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var uiStateJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherViewModel: WeatherViewModel by viewModel()

        setupObservableFields(weatherViewModel = weatherViewModel)
    }

    private fun setupObservableFields(weatherViewModel: WeatherViewModel) {
        uiStateJob = lifecycleScope.launchWhenStarted {
            weatherViewModel.currentWeather.collect {
                binding.currentWeatherTextView.text = it.data.toString()
            }
            weatherViewModel.currentWeatherError.collect {
                Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }

}

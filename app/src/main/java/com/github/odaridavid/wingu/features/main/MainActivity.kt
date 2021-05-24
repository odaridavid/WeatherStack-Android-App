package com.github.odaridavid.wingu.features.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.odaridavid.wingu.databinding.ActivityMainBinding
import com.github.odaridavid.wingu.features.forecast.ui.ForecastViewModel
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

        val forecastViewModel: ForecastViewModel by viewModel()

        setupObservableFields(forecastViewModel = forecastViewModel)
    }

    private fun setupObservableFields(forecastViewModel: ForecastViewModel) {
        uiStateJob = lifecycleScope.launchWhenStarted {
            forecastViewModel.currentWeather.collect {
                binding.currentWeatherTextView.text = it.data.toString()
            }
            forecastViewModel.currentWeatherError.collect {
                Toast.makeText(this@MainActivity, "${it.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }

}

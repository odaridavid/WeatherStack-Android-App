package com.github.odaridavid.wingu.features.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.odaridavid.wingu.databinding.FragmentCurrentWeatherBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class CurrentWeatherFragment : Fragment() {

    // region Members

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding get() = _binding!!
    private var uiStateJob: Job? = null

    // endregion

    // region Android Api

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentWeatherBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentWeatherViewModel: CurrentWeatherViewModel by viewModel()
        setupObservableFields(currentWeatherViewModel = currentWeatherViewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }

    // endregion

    // region Private Api

    private fun setupObservableFields(currentWeatherViewModel: CurrentWeatherViewModel) {
        uiStateJob = lifecycleScope.launchWhenStarted {
            currentWeatherViewModel.currentWeather.collect {
                binding.currentWeatherTextView.text = it.data.toString()
            }
            currentWeatherViewModel.currentWeatherError.collect {
                // TODO Display error
            }
        }
    }

    // endregion
}

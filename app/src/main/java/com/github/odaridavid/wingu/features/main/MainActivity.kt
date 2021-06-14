package com.github.odaridavid.wingu.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.wingu.databinding.ActivityMainBinding
import com.github.odaridavid.wingu.features.weather.ui.TabSwipePagerAdapter

class MainActivity : AppCompatActivity() {

    // region Android API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabView(binding)

    }

    // endregion

    // region Private Api

    private fun setupTabView(binding: ActivityMainBinding) {
        val tabs = binding.weatherDashboardTabLayout
        val viewPager = binding.weatherDashboardViewPager
        viewPager.adapter = TabSwipePagerAdapter(this@MainActivity, supportFragmentManager)
        tabs.setupWithViewPager(viewPager)
    }

    // endregion
}

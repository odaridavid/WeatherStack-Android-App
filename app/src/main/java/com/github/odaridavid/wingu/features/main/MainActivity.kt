package com.github.odaridavid.wingu.features.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.wingu.R
import com.github.odaridavid.wingu.databinding.ActivityMainBinding
import com.github.odaridavid.wingu.features.weather.ui.TabSwipePagerAdapter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    //TODO Use shared viewmodel to handle location changes and pass them to fragments

    // region Members

    private lateinit var binding:ActivityMainBinding

    // endregion

    // region Android API

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabView(binding)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_search_area -> {
                Snackbar.make(binding.root,"To Be Done :)",Snackbar.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
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

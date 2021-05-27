package com.github.odaridavid.wingu.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.odaridavid.wingu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}

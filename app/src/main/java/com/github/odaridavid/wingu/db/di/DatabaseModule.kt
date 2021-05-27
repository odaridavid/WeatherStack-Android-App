package com.github.odaridavid.wingu.db.di

import android.content.Context
import androidx.room.Room
import com.github.odaridavid.wingu.db.WeatherDao
import com.github.odaridavid.wingu.db.WinguDatabase
import org.koin.dsl.module

val databaseModule = module {
    // TODO Initialise db once everything is set and modify queries if need be
}

private fun provideWinguDatabase(context: Context): WinguDatabase =
    Room.databaseBuilder(context, WinguDatabase::class.java, WinguDatabase.DATABASE_NAME)
        .build()

private fun provideForecastDao(winguDatabase: WinguDatabase): WeatherDao =
    winguDatabase.getForecastsDao()

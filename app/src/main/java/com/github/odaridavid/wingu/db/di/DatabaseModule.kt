package com.github.odaridavid.wingu.db.di

import android.content.Context
import androidx.room.Room
import com.github.odaridavid.wingu.db.ForecastsDao
import com.github.odaridavid.wingu.db.WinguDatabase
import org.koin.dsl.module

val databaseModule = module {

}

private fun provideWinguDatabase(context: Context): WinguDatabase =
    Room.databaseBuilder(context, WinguDatabase::class.java, WinguDatabase.DATABASE_NAME)
        .build()

private fun provideForecastDao(winguDatabase: WinguDatabase): ForecastsDao =
    winguDatabase.getForecastsDao()

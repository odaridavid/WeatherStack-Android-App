package com.github.odaridavid.wingu

import android.app.Application
import com.github.odaridavid.wingu.api.di.apiModule
import com.github.odaridavid.wingu.db.di.databaseModule
import com.github.odaridavid.wingu.features.weather.di.weatherFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

// TODO Update readme with decisions ,what could be better, observations etc
class WinguApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WinguApplication)
            modules(
                apiModule,
                databaseModule,
                weatherFeatureModule
            )
        }
    }
}

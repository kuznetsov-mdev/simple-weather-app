package ru.sandbox.swa

import android.app.Application
import timber.log.Timber

class SimpleWeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
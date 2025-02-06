package ru.sandbox.swa

import android.app.Application

class SimpleWeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        SoLoader.init(this, false)
    }
}
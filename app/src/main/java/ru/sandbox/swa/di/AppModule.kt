package ru.sandbox.swa.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.BuildConfig
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("openWeatherApiKey")
    fun provideString(): String = BuildConfig.OPEN_WEATHER_API_KEY
}
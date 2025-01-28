package ru.sandbox.swa.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.WeatherForecastDatabase
import ru.sandbox.swa.dao.CityDao
import ru.sandbox.swa.dao.WeatherDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun providesWeatherForecastDataBase(appContext: Application): WeatherForecastDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = WeatherForecastDatabase::class.java,
            name = WeatherForecastDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesCityDao(db: WeatherForecastDatabase): CityDao = db.cityDao()

    @Provides
    @Singleton
    fun providesWeatherDao(db: WeatherForecastDatabase): WeatherDao = db.weatherDao()
}
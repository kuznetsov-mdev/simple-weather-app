package ru.sandbox.swa.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.WeatherForecastRoomDatabase
import ru.sandbox.swa.dao.CityDao
import ru.sandbox.swa.dao.WeatherDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    fun providesWeatherForecastDataBase(appContext: Application): WeatherForecastRoomDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = WeatherForecastRoomDatabase::class.java,
            name = WeatherForecastRoomDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesCityDao(db: WeatherForecastRoomDatabase): CityDao = db.cityDao()

    @Provides
    @Singleton
    fun providesWeatherDao(db: WeatherForecastRoomDatabase): WeatherDao = db.weatherDao()
}
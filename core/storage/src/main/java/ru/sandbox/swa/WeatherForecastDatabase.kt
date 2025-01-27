package ru.sandbox.swa

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sandbox.swa.WeatherForecastDatabase.Companion.DB_VERSION
import ru.sandbox.swa.dao.CityDao
import ru.sandbox.swa.dao.WeatherDao
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.entities.WeatherEntity

@Database(
    entities = [
        CityEntity::class,
        WeatherEntity::class
    ],
    version = DB_VERSION
)
abstract class WeatherForecastDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DB_NAME = "weather_forecast_db"
        const val DB_VERSION = 1
    }
}
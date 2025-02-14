package ru.sandbox.swa.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.withTransaction
import ru.sandbox.swa.db.WeatherForecastRoomDatabase.Companion.DB_VERSION
import ru.sandbox.swa.db.dao.CityDao
import ru.sandbox.swa.db.dao.WeatherDao
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.entities.WeatherEntity

@Database(
    entities = [
        CityEntity::class,
        WeatherEntity::class
    ],
    version = DB_VERSION
)
abstract class WeatherForecastRoomDatabase : RoomDatabase(), WeatherForecastDatabase {

    abstract override fun cityDao(): CityDao

    abstract override fun weatherDao(): WeatherDao

    override suspend fun saveWeatherForecast(cityEntity: CityEntity, weather: List<WeatherEntity>) {
        withTransaction {
            cityDao().insert(cityEntity)
            weatherDao().insert(weather)
        }
    }

    companion object {
        const val DB_NAME = "weather_forecast_db"
        const val DB_VERSION = 2
    }
}
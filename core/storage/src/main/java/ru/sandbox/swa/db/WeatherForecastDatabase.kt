package ru.sandbox.swa.db

import ru.sandbox.swa.db.dao.CityDao
import ru.sandbox.swa.db.dao.WeatherDao
import ru.sandbox.swa.db.entities.CityEntity
import ru.sandbox.swa.db.entities.WeatherEntity

interface WeatherForecastDatabase {

    fun cityDao(): CityDao

    fun weatherDao(): WeatherDao

    suspend fun saveWeatherForecast(cityEntity: CityEntity, weather: List<WeatherEntity>)
}
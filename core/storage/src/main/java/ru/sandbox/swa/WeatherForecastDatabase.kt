package ru.sandbox.swa

import ru.sandbox.swa.dao.CityDao
import ru.sandbox.swa.dao.WeatherDao
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.entities.WeatherEntity

interface WeatherForecastDatabase {

    fun cityDao(): CityDao

    fun weatherDao(): WeatherDao

    suspend fun saveWeatherForecast(cityEntity: CityEntity, weather: List<WeatherEntity>)
}
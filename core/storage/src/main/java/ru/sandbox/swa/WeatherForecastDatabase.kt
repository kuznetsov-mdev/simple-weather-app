package ru.sandbox.swa

import ru.sandbox.swa.dao.CityDao
import ru.sandbox.swa.dao.WeatherDao

interface WeatherForecastDatabase {

    fun cityDao(): CityDao

    fun weatherDao(): WeatherDao
}
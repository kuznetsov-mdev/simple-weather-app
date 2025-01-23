package ru.sandbox.swa.api

import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.model.WeatherItem

interface WeatherRepository {
    suspend fun getForecast(lat: String, lon: String): List<WeatherItem>

    suspend fun saveForecast(city: CityItem, forecast: List<WeatherItem>)
}
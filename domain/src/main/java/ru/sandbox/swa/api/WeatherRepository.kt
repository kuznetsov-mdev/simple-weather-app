package ru.sandbox.swa.api

import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.model.WeatherItem

interface WeatherRepository {
    suspend fun getForecast(lat: String, lon: String, apiKey: String): List<WeatherItem>

    suspend fun saveForecast(cityItem: CityItem, forecast: List<WeatherItem>, apiKey: String)
}
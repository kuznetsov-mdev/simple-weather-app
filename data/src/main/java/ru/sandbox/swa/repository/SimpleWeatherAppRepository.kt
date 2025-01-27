package ru.sandbox.swa.repository

import ru.sandbox.swa.OpenWeatherApi
import ru.sandbox.swa.api.WeatherRepository
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.model.WeatherItem

class SimpleWeatherAppRepository(
    private val openWeatherApi: OpenWeatherApi
) : WeatherRepository {
    override suspend fun getForecast(lat: String, lon: String, apiKey: String): List<WeatherItem> {
        TODO("Not yet implemented")
    }

    override suspend fun saveForecast(city: CityItem, forecast: List<WeatherItem>, apiKey: String) {
        TODO("Not yet implemented")
    }
}
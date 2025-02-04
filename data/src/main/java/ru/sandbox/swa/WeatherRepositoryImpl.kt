package ru.sandbox.swa

import ru.sandbox.swa.api.WeatherRepository
import ru.sandbox.swa.db.WeatherForecastDatabase
import ru.sandbox.swa.mapper.toCityEntity
import ru.sandbox.swa.mapper.toWeatherEntity
import ru.sandbox.swa.mapper.toWeatherItem
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.model.WeatherItem
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
    private val weatherForecastDatabase: WeatherForecastDatabase,
    private val connectivityService: NetworkConnectivityService,
) : WeatherRepository {

    override suspend fun getForecast(lat: String, lon: String, apiKey: String): List<WeatherItem> {
        return if (connectivityService.isNetworkAvailable()) {
            openWeatherApi
                .getWeatherForecast(lat, lon, apiKey)
                .forecast
                .map { it.toWeatherItem() }

        } else {
            weatherForecastDatabase
                .weatherDao()
                .getWeatherByCityId("${lat}_${lon}")
                .map { it.toWeatherItem() }
        }
    }

    override suspend fun saveForecast(cityItem: CityItem, forecast: List<WeatherItem>, apiKey: String) {
        weatherForecastDatabase.saveWeatherForecast(
            cityEntity = cityItem.toCityEntity(),
            weather = forecast.map { it.toWeatherEntity(cityItem.lat, cityItem.lon) }
        )
    }
}
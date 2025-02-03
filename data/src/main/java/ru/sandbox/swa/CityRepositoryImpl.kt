package ru.sandbox.swa

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.db.WeatherForecastDatabase
import ru.sandbox.swa.mapper.toCityItem
import ru.sandbox.swa.model.CityItem
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
    private val weatherForecastDatabase: WeatherForecastDatabase,
    private val connectivityService: NetworkConnectivityService,
) : CityRepository {

    override suspend fun getSearchHistory(apiKey: String): List<CityItem> {
        return weatherForecastDatabase.cityDao().getAll().map { it.toCityItem() }
    }

    override suspend fun getCitiesByName(query: String, count: Int, apiKey: String): List<CityItem> {
        return if (connectivityService.isNetworkAvailable()) {
            openWeatherApi.searchCity(query, count, apiKey).map { it.toCityItem() }
        } else {
            weatherForecastDatabase.cityDao().getCitiesByName(query).map { it.toCityItem() }
        }
    }

    override suspend fun saveCityToSearchHistory(cityModel: CityItem, apiKey: String) {
        //Need realization of DataStore in storage package
    }

    override suspend fun getLastSearchedCity(apiKey: String): Flow<CityItem?> {
        //Need realization of DataStore in storage package
        return emptyFlow()
    }
}
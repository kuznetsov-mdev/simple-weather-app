package ru.sandbox.swa

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.db.WeatherForecastDatabase
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.mapper.toCityEntity
import ru.sandbox.swa.mapper.toCityItem
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.proto.ProtoDataStore
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
    private val weatherForecastDatabase: WeatherForecastDatabase,
    private val connectivityService: NetworkConnectivityService,
    private val protoDataStore: ProtoDataStore<CityEntity>
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

    //Todo: remove api key from repository api
    override suspend fun saveCityToSearchHistory(cityModel: CityItem) {
        protoDataStore.saveEntity(cityModel.toCityEntity())
    }

    override suspend fun getLastSearchedCity(): Flow<CityItem?> {
        return protoDataStore.getEntity().map { it?.toCityItem() }
    }
}
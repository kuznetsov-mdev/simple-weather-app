package ru.sandbox.swa.api

import kotlinx.coroutines.flow.Flow
import ru.sandbox.swa.model.CityItem

interface CityRepository {

    suspend fun getSearchHistory(apiKey: String): List<CityItem>

    suspend fun getCitiesByName(query: String, count: Int, apiKey: String): List<CityItem>

    suspend fun saveCityToSearchHistory(cityModel: CityItem, apiKey: String)

    suspend fun getLastSearchedCity(apiKey: String): Flow<CityItem?>
}
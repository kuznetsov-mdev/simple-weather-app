package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(query: String, count: Int, apiKey: String): List<CityItem> {
        return cityRepository.getCitiesByName(query, count, apiKey)
    }
}
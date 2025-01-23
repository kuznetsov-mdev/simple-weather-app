package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem

class GetCitiesUseCase(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(query: String, count: Int): List<CityItem> {
        return cityRepository.getCitiesByName(query, count)
    }
}
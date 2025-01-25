package ru.sandbox.swa.usecase

import kotlinx.coroutines.flow.Flow
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem

class GetLastSearchedCityUseCase(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(apiKey: String): Flow<CityItem?> {
        return cityRepository.getLastSearchedCity(apiKey)
    }
}
package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem
import javax.inject.Inject

class GetSearchHistoryUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(apiKey: String): List<CityItem> {
        return cityRepository.getSearchHistory(apiKey)
    }
}
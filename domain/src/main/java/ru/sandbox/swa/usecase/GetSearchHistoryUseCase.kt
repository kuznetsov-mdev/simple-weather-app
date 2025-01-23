package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem

class GetSearchHistoryUseCase(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(): List<CityItem> {
        return cityRepository.getSearchHistory()
    }
}
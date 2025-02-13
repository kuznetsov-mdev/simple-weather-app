package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem
import javax.inject.Inject

class SaveCityToSearchHistoryUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(cityItem: CityItem) {
        cityRepository.saveCityToSearchHistory(cityItem)
    }
}
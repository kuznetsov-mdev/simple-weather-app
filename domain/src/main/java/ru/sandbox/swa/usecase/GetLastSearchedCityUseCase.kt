package ru.sandbox.swa.usecase

import kotlinx.coroutines.flow.Flow
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.model.CityItem
import javax.inject.Inject

class GetLastSearchedCityUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(): Flow<CityItem?> {
        return cityRepository.getLastSearchedCity()
    }
}
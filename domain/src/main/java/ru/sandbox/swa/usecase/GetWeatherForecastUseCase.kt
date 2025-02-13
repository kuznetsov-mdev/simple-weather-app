package ru.sandbox.swa.usecase

import ru.sandbox.swa.api.WeatherRepository
import ru.sandbox.swa.model.WeatherItem
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(lat: String, lon: String, apiKey: String): List<WeatherItem> {
        return weatherRepository.getForecast(lat, lon, apiKey)
    }
}
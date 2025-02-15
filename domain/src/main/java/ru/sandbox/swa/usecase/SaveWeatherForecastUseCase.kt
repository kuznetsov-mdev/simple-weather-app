package ru.sandbox.swa.usecase

import kotlinx.coroutines.flow.collectLatest
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.api.WeatherRepository
import ru.sandbox.swa.model.WeatherItem
import javax.inject.Inject

class SaveWeatherForecastUseCase @Inject constructor(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(forecast: List<WeatherItem>, apiKey: String) {
        cityRepository.getLastSearchedCity().collectLatest { city ->
            city?.let { cityItem ->
                weatherRepository.saveForecast(
                    cityItem = cityItem,
                    forecast = forecast,
                    apiKey = apiKey
                )
            }
        }
    }
}
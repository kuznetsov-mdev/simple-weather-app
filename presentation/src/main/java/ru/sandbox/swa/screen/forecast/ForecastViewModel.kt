package ru.sandbox.swa.screen.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.sandbox.swa.model.WeatherItem
import ru.sandbox.swa.usecase.GetWeatherForecastUseCase
import ru.sandbox.swa.usecase.SaveWeatherForecastUseCase
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ForecastViewModel @Inject constructor(
    @Named("openWeatherApiKey")
    private val apiKey: String,
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
    private val saveWeatherForecastUseCase: SaveWeatherForecastUseCase
) : ViewModel() {
    private val _isDataLoading = MutableStateFlow(true)
    val isDataLoading: StateFlow<Boolean>
        get() = _isDataLoading.asStateFlow()

    private val _forecast = MutableStateFlow<List<WeatherItem>>(emptyList())
    val forecast: StateFlow<List<WeatherItem>>
        get() = _forecast.asStateFlow()

    fun getForecast(lat: String, lon: String) {
        viewModelScope.launch {
            _forecast.value = getWeatherForecastUseCase(lat = lat, lon = lon, apiKey)
            _isDataLoading.value = false
            saveWeatherForecastUseCase(_forecast.value, apiKey)
        }
    }
}
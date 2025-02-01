package ru.sandbox.swa.dto

import WeatherDto
import com.squareup.moshi.Json

data class WeatherForecastDto(
    @Json(name = "list")
    val forecast: List<WeatherDto>
)

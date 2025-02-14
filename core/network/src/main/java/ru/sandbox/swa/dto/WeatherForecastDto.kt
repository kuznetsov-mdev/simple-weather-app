package ru.sandbox.swa.dto

import WeatherDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherForecastDto(
    @Json(name = "list")
    val forecast: List<WeatherDto>
)

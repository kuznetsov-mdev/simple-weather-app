package ru.sandbox.swa.model

data class WeatherItem(
    val id: Int = 0,
    val date: Int = 0,
    val temperature: Double = 0.0,
    val humidity: Int = 0,
    val windSpeed: Double = 0.0
)

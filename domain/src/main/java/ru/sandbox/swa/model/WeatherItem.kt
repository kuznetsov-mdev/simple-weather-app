package ru.sandbox.swa.model

data class WeatherItem(
    val id: Long = 0L,
    val date: Long = 0L,
    val temperature: Double = 0.0,
    val humidity: Int = 0,
    val windSpeed: Double = 0.0
)

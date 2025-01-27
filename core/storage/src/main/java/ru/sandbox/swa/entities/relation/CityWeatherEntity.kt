package ru.sandbox.swa.entities.relation

import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.entities.WeatherEntity

data class CityWeatherEntity(
    val city: CityEntity,
    val forecast: List<WeatherEntity>
)

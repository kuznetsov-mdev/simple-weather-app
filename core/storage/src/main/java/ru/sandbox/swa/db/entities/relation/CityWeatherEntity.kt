package ru.sandbox.swa.db.entities.relation

import ru.sandbox.swa.db.entities.CityEntity
import ru.sandbox.swa.db.entities.WeatherEntity

data class CityWeatherEntity(
    val city: CityEntity,
    val forecast: List<WeatherEntity>
)

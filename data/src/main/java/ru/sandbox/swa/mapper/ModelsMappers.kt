package ru.sandbox.swa.mapper

import WeatherDto
import ru.sandbox.swa.dto.CityDto
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.entities.WeatherEntity
import ru.sandbox.swa.model.CityItem
import ru.sandbox.swa.model.WeatherItem

fun WeatherDto.toWeatherItem(): WeatherItem {
    return WeatherItem(
        id = this.dateTimeMs,
        date = this.dateTimeMs,
        temperature = this.commonInfo.temperature,
        humidity = this.commonInfo.humidity,
        windSpeed = this.wind.speed
    )
}

fun WeatherEntity.toWeatherItem(): WeatherItem {
    return WeatherItem(
        id = this.id,
        date = this.date,
        temperature = this.temperature,
        humidity = this.humidity,
        windSpeed = this.windSpeed
    )
}

fun WeatherItem.toWeatherEntity(lat: Double, lon: Double): WeatherEntity {
    return WeatherEntity(
        id = this.id,
        date = this.date,
        temperature = this.temperature,
        humidity = this.humidity,
        windSpeed = this.windSpeed,
        cityId = "${lat}_${lon}"
    )
}


fun CityDto.toCityItem(): CityItem {
    return CityItem(
        country = this.country,
        region = this.state ?: DefaultValues.DEFAULT_REGION,
        name = this.name,
        lat = this.lat,
        lon = this.lon
    )
}

fun CityEntity.toCityItem(): CityItem {
    return CityItem(
        country = this.country,
        region = this.region ?: DefaultValues.DEFAULT_REGION,
        name = this.name,
        lat = this.lat,
        lon = this.lon
    )
}

fun CityItem.toCityEntity(): CityEntity {
    return CityEntity(
        id = "${this.lat}_${this.lon}",
        country = this.country,
        region = this.region,
        name = this.name,
        lat = this.lat,
        lon = this.lon
    )
}

object DefaultValues {
    const val DEFAULT_REGION = ""
}
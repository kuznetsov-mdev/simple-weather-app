package ru.sandbox.swa.dto

import CloudsDto
import CommonInfoDto
import RainDto
import WindDto
import com.squareup.moshi.Json

data class WeatherForecastDto(
    @Json(name = "clouds")
    val clouds: CloudsDto,
    @Json(name = "dt")
    val dateTimeMs: Int,
    @Json(name = "dt_txt")
    val date: String,
    @Json(name = "main")
    val commonInfo: CommonInfoDto,
    @Json(name = "rain")
    val rain: RainDto?,
    @Json(name = "wind")
    val wind: WindDto
)

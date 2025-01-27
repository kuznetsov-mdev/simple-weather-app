package ru.sandbox.swa.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityDto(
    @Json(name = "country")
    val country: String,
    @Json(name = "state")
    val state: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double,
)

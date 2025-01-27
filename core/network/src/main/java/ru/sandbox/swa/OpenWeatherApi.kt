package ru.sandbox.swa

import retrofit2.http.GET
import retrofit2.http.Query
import ru.sandbox.swa.dto.CityDto
import ru.sandbox.swa.dto.WeatherForecastDto

interface OpenWeatherApi {
    @GET("/geo/1.0/direct")
    suspend fun searchCity(
        @Query(value = "q") query: String,
        @Query(value = "limit") count: Int,
        @Query(value = "appid") appid: String
    ): List<CityDto>

    @GET("/data/2.5/forecast")
    suspend fun getWeatherForecast(
        @Query(value = "lat") lat: String,
        @Query(value = "lon") lon: String,
        @Query(value = "appid") appid: String,
        @Query(value = "units") units: String = "metric"
    ): WeatherForecastDto
}
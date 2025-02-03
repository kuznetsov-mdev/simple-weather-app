package ru.sandbox.swa.db.contract

object WeatherContract {
    const val TABLE_NAME = "weather_forecast"

    object Column {
        const val ID = "id"
        const val DATE = "date"
        const val TEMPERATURE = "temperature"
        const val HUMIDITY = "humidity"
        const val WIND_SPEED = "wind_speed"
        const val CITY_ID = "city_id"
    }
}
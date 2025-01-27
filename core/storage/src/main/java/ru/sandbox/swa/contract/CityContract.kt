package ru.sandbox.swa.contract

object CityContract {
    const val TABLE_NAME = "cities"

    object Column {
        const val ID = "id"
        const val COUNTRY = "country"
        const val REGION = "region"
        const val NAME = "name"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
    }
}
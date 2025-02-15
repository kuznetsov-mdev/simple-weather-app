package ru.sandbox.swa.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import ru.sandbox.swa.db.contract.CityContract
import ru.sandbox.swa.db.contract.WeatherContract

@Entity(
    tableName = WeatherContract.TABLE_NAME,
    primaryKeys = [
        WeatherContract.Column.ID,
        WeatherContract.Column.CITY_ID
    ],
    foreignKeys = [
        ForeignKey(
            entity = CityEntity::class,
            parentColumns = [CityContract.Column.ID],
            childColumns = [WeatherContract.Column.CITY_ID]
        )
    ]
)
data class WeatherEntity(
    @ColumnInfo(name = WeatherContract.Column.ID, index = true)
    val id: Long,
    @ColumnInfo(name = WeatherContract.Column.DATE)
    val date: Long,
    @ColumnInfo(name = WeatherContract.Column.TEMPERATURE)
    val temperature: Double,
    @ColumnInfo(name = WeatherContract.Column.HUMIDITY)
    val humidity: Int,
    @ColumnInfo(name = WeatherContract.Column.WIND_SPEED)
    val windSpeed: Double,
    @ColumnInfo(name = WeatherContract.Column.CITY_ID)
    val cityId: String
)

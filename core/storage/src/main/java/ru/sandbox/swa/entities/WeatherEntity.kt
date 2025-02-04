package ru.sandbox.swa.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.sandbox.swa.db.contract.CityContract
import ru.sandbox.swa.db.contract.WeatherContract

@Entity(
    tableName = WeatherContract.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CityEntity::class,
            parentColumns = [CityContract.Column.ID],
            childColumns = [WeatherContract.Column.CITY_ID]
        )
    ]
)
data class WeatherEntity(
    @PrimaryKey
    @ColumnInfo(name = WeatherContract.Column.ID, index = true)
    val id: Int,
    @ColumnInfo(name = WeatherContract.Column.DATE)
    val date: Int,
    @ColumnInfo(name = WeatherContract.Column.TEMPERATURE)
    val temperature: Double,
    @ColumnInfo(name = WeatherContract.Column.HUMIDITY)
    val humidity: Int,
    @ColumnInfo(name = WeatherContract.Column.WIND_SPEED)
    val windSpeed: Double,
    @ColumnInfo(name = WeatherContract.Column.CITY_ID)
    val cityId: String
)

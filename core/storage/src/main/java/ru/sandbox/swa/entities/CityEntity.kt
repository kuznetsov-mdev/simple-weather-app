package ru.sandbox.swa.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import ru.sandbox.swa.contract.CityContract

@Serializable
@Entity(tableName = CityContract.TABLE_NAME)
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CityContract.Column.ID, index = true)
    val id: String,
    @ColumnInfo(name = CityContract.Column.COUNTRY)
    val country: String,
    @ColumnInfo(name = CityContract.Column.REGION)
    val region: String?,
    @ColumnInfo(name = CityContract.Column.NAME)
    val name: String,
    @ColumnInfo(name = CityContract.Column.LATITUDE)
    val lat: Double,
    @ColumnInfo(name = CityContract.Column.LONGITUDE)
    val lon: Double,
) {
    companion object {
        val EMPTY = CityEntity("", "", "", "", 0.0, 0.0)
    }
}

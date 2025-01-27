package ru.sandbox.swa.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sandbox.swa.contract.WeatherContract
import ru.sandbox.swa.entities.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(entity = WeatherEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forecast: List<WeatherEntity>)

    @Query("SELECT * FROM ${WeatherContract.TABLE_NAME} WHERE ${WeatherContract.Column.CITY_ID}=:cityId")
    suspend fun getWeatherByCityId(cityId: String): List<WeatherEntity>
}
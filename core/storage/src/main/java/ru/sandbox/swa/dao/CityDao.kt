package ru.sandbox.swa.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.sandbox.swa.contract.CityContract
import ru.sandbox.swa.entities.CityEntity

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cityEntity: CityEntity)

    @Query("SELECT * FROM ${CityContract.TABLE_NAME}")
    suspend fun getAll(): List<CityEntity>

    @Query("SELECT * FROM ${CityContract.TABLE_NAME} WHERE ${CityContract.Column.NAME} LIKE :query")
    suspend fun getCitiesByName(query: String): List<CityEntity>
}
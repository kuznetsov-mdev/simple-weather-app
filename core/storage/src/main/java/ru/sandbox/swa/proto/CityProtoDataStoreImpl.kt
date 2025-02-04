package ru.sandbox.swa.proto

import android.app.Application
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sandbox.swa.entities.CityEntity
import javax.inject.Inject

class CityProtoDataStoreImpl @Inject constructor(
    private val context: Application
) : ProtoDataStore<CityEntity> {
    override suspend fun saveEntity(entity: CityEntity) {
        context.datastore.updateData {
            it.copy(
                country = entity.country,
                region = entity.region,
                name = entity.name,
                lat = entity.lat,
                lon = entity.lon
            )
        }
    }

    override suspend fun getEntity(): Flow<CityEntity?> {
        return context.datastore.data.map {
            if (it == CityEntity.EMPTY) null else it
        }
    }
}
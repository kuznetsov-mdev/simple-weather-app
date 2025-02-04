package ru.sandbox.swa.proto

import android.content.Context
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import ru.sandbox.swa.entities.CityEntity
import java.io.InputStream
import java.io.OutputStream

val Context.datastore by dataStore("city-search-history.json", CityEntitySerializer)

object CityEntitySerializer : Serializer<CityEntity> {
    override val defaultValue: CityEntity get() = CityEntity.EMPTY

    override suspend fun readFrom(input: InputStream): CityEntity {
        return try {
            Json.decodeFromString(
                deserializer = CityEntity.serializer(),
                string = input.readBytes().toString()
            )
        } catch (e: SerializationException) {
            defaultValue
        }
    }

    override suspend fun writeTo(t: CityEntity, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = CityEntity.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
    }
}
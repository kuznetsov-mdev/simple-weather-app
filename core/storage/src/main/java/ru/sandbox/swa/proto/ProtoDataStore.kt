package ru.sandbox.swa.proto

import kotlinx.coroutines.flow.Flow

interface ProtoDataStore<T> {

    suspend fun saveEntity(entity: T)

    suspend fun getEntity(): Flow<T?>
}
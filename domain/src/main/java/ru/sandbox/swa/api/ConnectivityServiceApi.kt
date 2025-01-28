package ru.sandbox.swa.api

import kotlinx.coroutines.flow.Flow

interface ConnectivityServiceApi {
    fun observe(): Flow<Status>

    fun isNetworkAvailable(): Boolean

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}
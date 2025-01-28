package ru.sandbox.swa.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.NetworkConnectivityService
import ru.sandbox.swa.api.ConnectivityServiceApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun providesNetworkConnectivityService(application: Application): ConnectivityServiceApi =
        NetworkConnectivityService(context = application)

}
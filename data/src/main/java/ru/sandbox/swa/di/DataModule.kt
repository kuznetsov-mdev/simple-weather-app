package ru.sandbox.swa.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.CityRepositoryImpl
import ru.sandbox.swa.NetworkConnectivityService
import ru.sandbox.swa.OpenWeatherApi
import ru.sandbox.swa.WeatherRepositoryImpl
import ru.sandbox.swa.api.CityRepository
import ru.sandbox.swa.api.WeatherRepository
import ru.sandbox.swa.db.WeatherForecastDatabase
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.proto.ProtoDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesWeatherRepository(
        openWeatherApi: OpenWeatherApi,
        weatherForecastDatabase: WeatherForecastDatabase,
        connectivityService: NetworkConnectivityService
    ): WeatherRepository =
        WeatherRepositoryImpl(openWeatherApi, weatherForecastDatabase, connectivityService)

    @Provides
    @Singleton
    fun providesCityRepository(
        openWeatherApi: OpenWeatherApi,
        weatherForecastDatabase: WeatherForecastDatabase,
        connectivityService: NetworkConnectivityService,
        protoDataStore: ProtoDataStore<CityEntity>
    ): CityRepository =
        CityRepositoryImpl(openWeatherApi, weatherForecastDatabase, connectivityService, protoDataStore)
}
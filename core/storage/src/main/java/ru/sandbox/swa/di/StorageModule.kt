package ru.sandbox.swa.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sandbox.swa.db.MIGRATION_1_2
import ru.sandbox.swa.db.WeatherForecastDatabase
import ru.sandbox.swa.db.WeatherForecastRoomDatabase
import ru.sandbox.swa.db.dao.CityDao
import ru.sandbox.swa.db.dao.WeatherDao
import ru.sandbox.swa.entities.CityEntity
import ru.sandbox.swa.proto.CityProtoDataStoreImpl
import ru.sandbox.swa.proto.ProtoDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    @Singleton
    fun providesWeatherForecastDataBase(appContext: Application): WeatherForecastDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = WeatherForecastRoomDatabase::class.java,
            name = WeatherForecastRoomDatabase.DB_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Provides
    @Singleton
    fun providesCityDao(db: WeatherForecastDatabase): CityDao = db.cityDao()

    @Provides
    @Singleton
    fun providesWeatherDao(db: WeatherForecastDatabase): WeatherDao = db.weatherDao()

    @Provides
    @Singleton
    fun providesCityProtoDatastore(context: Application): ProtoDataStore<CityEntity> =
        CityProtoDataStoreImpl(context)

}
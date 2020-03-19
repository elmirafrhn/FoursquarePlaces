package com.farahani.elmira.data.entity

import android.app.Application
import androidx.room.Room
import com.farahani.elmira.data.entity.db.PlacesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by elmira on 16, March, 2020
 */
@Module
class EntityModule {

    @Provides
    fun venuesDao(db: PlacesDatabase) = db.venuesDao()

    @Provides
    @Singleton
    fun database(application: Application): PlacesDatabase = Room.databaseBuilder(
        application.applicationContext,
        PlacesDatabase::class.java,
        "places_db"
    ).createFromAsset("places_db")
        .build()
}
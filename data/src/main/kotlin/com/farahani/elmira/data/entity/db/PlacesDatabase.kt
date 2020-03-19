package com.farahani.elmira.data.entity.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farahani.elmira.data.entity.dao.VenuesDao
import com.farahani.elmira.data.entity.local.VenueEntity

/**
 * Created by elmira on 16, March, 2020
 */
@Database(
    entities = [
        VenueEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PlacesDatabase : RoomDatabase() {

    abstract fun venuesDao(): VenuesDao
}

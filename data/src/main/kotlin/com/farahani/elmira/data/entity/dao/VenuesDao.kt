package com.farahani.elmira.data.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farahani.elmira.data.entity.local.VenueEntity
import io.reactivex.Flowable

/**
 * Created by elmira on 17, March, 2020
 */
@Dao
interface VenuesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(venues: List<VenueEntity>)

    @Query("SELECT * FROM venues ORDER BY id ASC")
    fun selectAll(): Flowable<MutableList<VenueEntity>>
}
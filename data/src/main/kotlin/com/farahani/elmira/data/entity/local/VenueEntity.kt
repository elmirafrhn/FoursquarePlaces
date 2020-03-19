package com.farahani.elmira.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by elmira on 16, March, 2020
 */
@Entity(tableName = "venues")
data class VenueEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val address: String,
    val contact: String,
    val icon: String,
    val website: String
)
package com.farahani.elmira.domain.entity

/**
 * Created by elmira on 16, March, 2020
 */
data class VenueObject(
    val id: String,
    val name: String,
    val location: LocationObject,
    val categories: List<CategoryObject>,
    val venuePage: VenuePageObject
)

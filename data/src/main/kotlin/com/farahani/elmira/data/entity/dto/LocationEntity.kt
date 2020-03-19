package com.farahani.elmira.data.entity.dto

/**
 * Created by elmira on 11, March, 2020
 */
data class LocationEntity(
    val address: String,
    val crossStreet: String,
    val lat: String,
    val lng: String,
    val distance: String,
    val postalCode: String,
    val cc: String,
    val city: String,
    val state: String,
    val country: String,
    val formattedAddress: Map<String, String>
)
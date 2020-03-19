package com.farahani.elmira.domain.entity

/**
 * Created by elmira on 11, March, 2020
 */
data class LocationObject(
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
package com.farahani.elmira.data.entity.dto

import com.farahani.elmira.data.entity.local.VenueEntity

/**
 * Created by elmira on 16, March, 2020
 */
data class Response(
    val venues: List<VenueEntity>
)
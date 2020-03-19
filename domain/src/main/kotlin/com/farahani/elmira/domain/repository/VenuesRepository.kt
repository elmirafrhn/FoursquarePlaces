package com.farahani.elmira.domain.repository

import com.farahani.elmira.domain.entity.SearchVenuesRequest
import io.reactivex.Completable

/**
 * Created by elmira on 11, March, 2020
 */
interface VenuesRepository {

    fun searchVenues(location: SearchVenuesRequest): Completable
}
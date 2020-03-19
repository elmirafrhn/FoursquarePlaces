package com.farahani.elmira.data.repository

import com.farahani.elmira.data.datasource.VenuesDataSource
import com.farahani.elmira.domain.entity.SearchVenuesRequest
import com.farahani.elmira.domain.repository.VenuesRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by elmira on 16, March, 2020
 */
class VenuesRepositoryImpl @Inject constructor(
    private val dataSource: VenuesDataSource
) : VenuesRepository {
    override fun searchVenues(location: SearchVenuesRequest): Completable = dataSource.searchVenues(location.lat,location.long)
}
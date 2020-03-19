package com.farahani.elmira.data.datasource

import android.util.Log
import com.farahani.elmira.data.dataservice.VenuesDataService
import com.farahani.elmira.data.entity.dao.VenuesDao
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by elmira on 16, March, 2020
 */
class VenuesDataSourceImpl @Inject constructor(
    private val dataService: VenuesDataService,
    private val venuesDao: VenuesDao
) : VenuesDataSource {
    override fun searchVenues(lat:String,long:String): Completable = persistData(lat,long)

    private fun persistData(lat:String,long:String) =
        getVenuesFromApi("$lat,$long")
            .map { it }
            .doOnNext {
                Log.d("elmira", "")
                // venuesDao.insert(it.venues)
            }.ignoreElements()

    private fun getVenuesFromApi(latLong:String) = dataService.searchVenues(latLong)
}
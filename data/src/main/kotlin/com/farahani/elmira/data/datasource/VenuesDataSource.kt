package com.farahani.elmira.data.datasource

import io.reactivex.Completable

/**
 * Created by elmira on 16, March, 2020
 */
interface VenuesDataSource {

    fun searchVenues(lat:String,long:String):Completable
}
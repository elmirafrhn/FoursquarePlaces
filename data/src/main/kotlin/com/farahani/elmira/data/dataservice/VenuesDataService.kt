package com.farahani.elmira.data.dataservice

import com.farahani.elmira.data.BuildConfig
import com.farahani.elmira.data.entity.dto.Response
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by elmira on 16, March, 2020
 */
interface VenuesDataService {

    @GET(value = "${BuildConfig.BASE_URL}/venues/search")
    fun searchVenues(
        @Query("ll") latLong: String
//        @Query("client_id") BuildConfig.CLIENT_ID,
//        @Query("client_secret") BuildConfig.CLIENT_SECRECT,
//        @Query("v") BuildConfig.VERSIONING
    ): Flowable<Response>
}
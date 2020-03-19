package com.farahani.elmira.data.dataservice

import android.app.Application
import com.farahani.elmira.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by elmira on 16, March, 2020
 */
@Singleton
class DataServiceFactory @Inject constructor(
//    val preferencesHelper: PreferencesHelper,
    val application: Application
) {

    fun <T> create(serviceClass: Class<T>): T =
        retrofit(TIME_OUT_API).create(serviceClass)

    fun <T> createForUploadImage(serviceClass: Class<T>): T =
        retrofit(TIME_OUT_IMAGE_UPLOAD).create(serviceClass)


    private fun retrofit(type: Long): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClientBuilder(type).build())
        .build()


    private fun okHttpClientBuilder(timeout: Long): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(httpLoggingInterceptor())
    }


    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    companion object {
        const val TIME_OUT_CONNECTION: Long = 30
        const val TIME_OUT_API: Long = 30
        const val TIME_OUT_IMAGE_UPLOAD: Long = 50
    }
}
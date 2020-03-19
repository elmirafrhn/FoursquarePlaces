package com.farahani.elmira.data.dataservice

import android.util.Base64
import com.farahani.elmira.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

/**
 * Created by elmira on 16, March, 2020
 */
class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        requestBuilder.header("App-Version", BuildConfig.VERSION_NAME)
        requestBuilder.header("Phone-Base", "true")
        requestBuilder.header("X-AGENT-TYPE", "Android App")
        requestBuilder.header("X-BUILD-MODE", if (BuildConfig.DEBUG) "Debug" else "Release")
        requestBuilder.header("X-FLAVOR", BuildConfig.FLAVOR)

        if (BuildConfig.DEBUG) {
            val credentials = String.format(Locale.US, "%s:%s", "trumpet", "newsite")
            requestBuilder.header(
                "Authorization",
                "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
            )
        }

        originalRequest = requestBuilder.build()

        return chain.proceed(originalRequest)
    }
}
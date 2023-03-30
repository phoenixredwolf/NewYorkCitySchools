package com.phoenixredwolf.newyorkcityschools.network

import com.phoenixredwolf.newyorkcityschools.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object SchoolApi {

    const val BASE_URL = "https://data.cityofnewyork.us/resource/"

    private val logger = HttpLoggingInterceptor()

    val httpClient = if (BuildConfig.DEBUG) {
        OkHttpClient.Builder().apply {
            addInterceptor{
                    chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-App-Token", BuildConfig.APP_TOKEN)
                return@addInterceptor chain.proceed(builder.build())
            }
            logger.level = HttpLoggingInterceptor.Level.BODY
            addNetworkInterceptor(logger)
        }.build()
    } else {
        OkHttpClient.Builder().apply {
            addInterceptor{
                    chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-App-Token", BuildConfig.APP_TOKEN)
                return@addInterceptor chain.proceed(builder.build())
            }
        }.build()
    }

}
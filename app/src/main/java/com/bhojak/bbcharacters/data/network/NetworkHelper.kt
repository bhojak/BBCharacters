package com.bhojak.bbcharacters.data.network


import com.bhojak.bbcharacters.BuildConfig
import com.bhojak.bbcharacters.data.network.contract.NetworkHelperContract
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkHelper : NetworkHelperContract {
    override fun createHttpClient(): OkHttpClient {
        val okHttpClient: OkHttpClient

        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val originalRequest = chain.request()

            val requestBuilder = originalRequest.newBuilder()

            val newRequest = requestBuilder.build()
            val response = chain.proceed(newRequest)
            response
        }

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        okHttpClient = builder.build()
        return okHttpClient
    }

}
package com.bhojak.bbcharacters.data.network.contract

import okhttp3.OkHttpClient

interface NetworkHelperContract{
    fun createHttpClient() : OkHttpClient
}
package com.bhojak.bbcharacters.data.network.contract


import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface BreakingBadApi {
    @GET("characters/")
    fun getCharacterList() : Deferred<Response<List<BreakingBadCharacter>>>
}
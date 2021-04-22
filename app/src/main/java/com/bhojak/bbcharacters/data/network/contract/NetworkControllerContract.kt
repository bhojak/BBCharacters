package com.bhojak.bbcharacters.data.network.contract


import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface NetworkControllerContract {
    fun getCharacterList(): Deferred<Response<List<BreakingBadCharacter>>>
}
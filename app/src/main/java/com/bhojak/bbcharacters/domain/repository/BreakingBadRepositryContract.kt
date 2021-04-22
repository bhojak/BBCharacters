package com.bhojak.bbcharacters.domain.repository


import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface BreakingBadRepositoryContract {

    fun getCharacterListAsync(): Deferred<Response<List<BreakingBadCharacter>>>
}
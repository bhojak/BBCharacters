package com.bhojak.bbcharacters.domain.usecase


import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import com.bhojak.bbcharacters.domain.repository.BreakingBadRepositoryContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class GetCharactersUseCase constructor(private val repository: BreakingBadRepositoryContract) {

    fun getCharacterListAsync(): Deferred<Response<List<BreakingBadCharacter>>> {
        return repository.getCharacterListAsync()
    }
}
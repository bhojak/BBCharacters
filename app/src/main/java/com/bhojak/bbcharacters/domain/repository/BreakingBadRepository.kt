package com.bhojak.bbcharacters.domain.repository


import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import com.bhojak.bbcharacters.data.network.contract.NetworkControllerContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class BreakingBadRepository  constructor(private val networkController: NetworkControllerContract) :
    BreakingBadRepositoryContract {
    override fun getCharacterListAsync(): Deferred<Response<List<BreakingBadCharacter>>> {
        return networkController.getCharacterList()
    }
}
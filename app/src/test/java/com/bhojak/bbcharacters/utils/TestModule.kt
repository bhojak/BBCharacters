package com.bhojak.bbcharacters.utils


import com.bhojak.bbcharacters.data.network.NetworkController
import com.bhojak.bbcharacters.data.network.contract.NetworkControllerContract
import com.bhojak.bbcharacters.data.network.contract.NetworkHelperContract
import com.bhojak.bbcharacters.domain.repository.BreakingBadRepository
import com.bhojak.bbcharacters.domain.repository.BreakingBadRepositryContract
import com.bhojak.bbcharacters.domain.usecase.GetCharactersUseCase
import com.bhojak.bbcharacters.ui.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object TestModule {
    fun getTestModules() = module {
        factory<BreakingBadRepositryContract> { BreakingBadRepository(get()) }
        single<NetworkHelperContract> { NetworkTestHelper() }
        single<NetworkControllerContract> { NetworkController(get()) }
        factory { GetCharactersUseCase(get()) }
        viewModel { CharacterViewModel(get()) }
    }
}
package com.bhojak.bbcharacters.data.network


import com.bhojak.bbcharacters.data.network.contract.NetworkControllerContract
import com.bhojak.bbcharacters.data.network.contract.NetworkHelperContract
import org.koin.dsl.module

object NetworkModule {
    val networkModule = module {
        single<NetworkHelperContract> { NetworkHelper() }
        single<NetworkControllerContract> { NetworkController(get()) }
    }
}
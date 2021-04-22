package com.bhojak.bbcharacters.main


import com.bhojak.bbcharacters.data.network.NetworkModule
import com.bhojak.bbcharacters.domain.DomainModule
import com.bhojak.bbcharacters.ui.UIModule


object AppComponent {
    val getAllModules =
        listOf(
            DomainModule.getCharacterRepositoryModule,
            NetworkModule.networkModule,
            UIModule.getUiModule
        )
}
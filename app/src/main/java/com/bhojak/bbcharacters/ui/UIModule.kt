package com.bhojak.bbcharacters.ui


import com.bhojak.bbcharacters.domain.usecase.GetCharactersUseCase
import com.bhojak.bbcharacters.ui.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModule {
    val getUiModule = module {
        factory { GetCharactersUseCase(get()) }
        viewModel { CharacterViewModel(get()) }
    }
}
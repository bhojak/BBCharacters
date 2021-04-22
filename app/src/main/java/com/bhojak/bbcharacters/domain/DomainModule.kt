package com.bhojak.bbcharacters.domain


import com.bhojak.bbcharacters.domain.repository.BreakingBadRepository
import com.bhojak.bbcharacters.domain.repository.BreakingBadRepositoryContract
import org.koin.dsl.module

object DomainModule {
    val getCharacterRepositoryModule = module {
        factory<BreakingBadRepositoryContract> { BreakingBadRepository(get()) }
    }
}
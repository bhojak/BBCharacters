package com.bhojak.bbcharacters.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bhojak.bbcharacters.data.Resource
import com.bhojak.bbcharacters.data.Status
import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import com.bhojak.bbcharacters.data.network.CallHandler
import com.bhojak.bbcharacters.data.network.contract.NetworkHelperContract
import com.bhojak.bbcharacters.utils.NetworkTestHelper
import com.bhojak.bbcharacters.utils.TestModule
import com.bhojak.bbcharacters.utils.TestResponse

import com.jraska.livedata.test
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class GetCharactersUseCaseTest : KoinTest {

    private var list: List<BreakingBadCharacter>? = null
    private lateinit var response: Resource<List<BreakingBadCharacter>>
    val networkHelper: NetworkHelperContract by inject()
    val getCharactersUseCase : GetCharactersUseCase by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(TestModule.getTestModules()))
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `test all fields that are mandatory and have some value ie the character image and character name`(){
        (networkHelper as NetworkTestHelper).setMockedResponse(TestResponse("characterListResponse.json", 200))

        response = CallHandler<List<BreakingBadCharacter>>().makeCall(getCharactersUseCase.getCharacterList())
            .test()
            .awaitValue()
            .assertHasValue()
            .assertValue{it.status == Status.Loading}
            .awaitNextValue()
            .assertValue {
                it.status == Status.Success
            }
            .value()

        list = response.data
        if (!list.isNullOrEmpty()){
            assert(list!!.isNotEmpty())
            list!!.forEach {
                assert(it.characterImage.isNotEmpty())
                assert(it.name.isNotEmpty())
            }
        }else{
            assert(false)
        }
    }

    @Test
    fun `test all fields exist for Walter White`(){
        (networkHelper as NetworkTestHelper).setMockedResponse(TestResponse("characterListResponse.json", 200))

        response = CallHandler<List<BreakingBadCharacter>>().makeCall(getCharactersUseCase.getCharacterList())
            .test()
            .awaitValue()
            .assertHasValue()
            .assertValue{it.status == Status.Loading}
            .awaitNextValue()
            .assertValue {
                it.status == Status.Success
            }
            .value()

        list = response.data

        if (!list.isNullOrEmpty()){
            assert(list!!.isNotEmpty())

            val walterWhite : BreakingBadCharacter? = list!!.find { it.name == "Walter White" }

            assert(walterWhite != null)

            walterWhite?.let {
                assert(it.name.isNotEmpty())
                assert(it.occupation.isNotEmpty())
                assert(it.status!!.isNotEmpty())
                assert(it.nickname!!.isNotEmpty())
                assert(it.seasonAppearance!!.isNotEmpty())

            }
        }else{
            assert(false)
        }
    }
}


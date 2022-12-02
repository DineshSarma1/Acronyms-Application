package com.example.acronymsapp.data

import com.example.acronymsapp.util.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AcronymsRepositoryImplTest {

    private lateinit var acronymsRepository: AcronymsRepository
    private lateinit var fakeData: MutableList<AcronymResponse>

    @Before
    fun setup() {
        fakeData = mutableListOf(
            AcronymResponse(
                "HMM", mutableListOf(
                    FullForm(
                        "heavy meromyosin", 267, 1971, mutableListOf(
                            Variation("heavy meromyosin", 244, 1971),
                            Variation("Heavy meromyosin", 12, 1975)
                        )
                    ),
                    FullForm(
                        "hidden Markov model", 267, 1971, mutableListOf(
                            Variation("hidden Markov model", 148, 1971),
                            Variation("hidden Markov model", 29, 1975)
                        )
                    )
                )
            )
        )

        val apiService = FakeDataSource()
        acronymsRepository = AcronymsRepositoryImpl(apiService)
    }

    @Test
    fun `check data from repository is same as expected or not`() = runBlocking {
            val response = acronymsRepository.getAcronymList("HMM")
            assertEquals(NetworkState.Success(fakeData),response)
    }


}
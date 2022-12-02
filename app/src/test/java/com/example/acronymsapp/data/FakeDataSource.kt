package com.example.acronymsapp.data

import com.example.acronymsapp.util.NetworkState
import retrofit2.Response

class FakeDataSource : AcronymsApiService{

    override suspend fun getAcronymList(sf: String): Response<MutableList<AcronymResponse>> {
        val fakeData = mutableListOf<AcronymResponse>(
            AcronymResponse("HMM", mutableListOf(
                FullForm("heavy meromyosin", 267, 1971, mutableListOf(
                    Variation("heavy meromyosin", 244, 1971),
                    Variation("Heavy meromyosin", 12, 1975)
                )),
                FullForm("hidden Markov model", 267, 1971, mutableListOf(
                    Variation("hidden Markov model", 148, 1971),
                    Variation("hidden Markov model", 29, 1975)
                ))
            ))
        )
        return Response.success(fakeData)
    }

}
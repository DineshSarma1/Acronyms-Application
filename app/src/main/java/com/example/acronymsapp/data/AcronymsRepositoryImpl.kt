package com.example.acronymsapp.data

import com.example.acronymsapp.util.NetworkState
import retrofit2.Response
import javax.inject.Inject

class AcronymsRepositoryImpl @Inject constructor(
    private val apiService: AcronymsApiService
) : AcronymsRepository{

    override suspend fun getAcronymList(sf: String): NetworkState<MutableList<AcronymResponse>> {
        val response = apiService.getAcronymList(sf)

        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

}
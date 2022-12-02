package com.example.acronymsapp.data

import retrofit2.Response
import javax.inject.Inject

class AcronymsRepositoryImpl @Inject constructor(
    private val apiService: AcronymsApiService
) : AcronymsRepository{

    override suspend fun getAcronymList(sf: String): Response<MutableList<AcronymResponse>> {
        return apiService.getAcronymList(sf)
    }

}
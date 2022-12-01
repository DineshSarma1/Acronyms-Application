package com.example.acronymsapp.data

import javax.inject.Inject

class AcronymsRepositoryImpl @Inject constructor(
    private val apiService: AcronymsApiService
) : AcronymsRepository{

    override suspend fun getAcronymList(sf: String): MutableList<AcronymResponse> {
        return apiService.getAcronymList(sf)
    }

}
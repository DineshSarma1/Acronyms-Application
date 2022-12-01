package com.example.acronymsapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymsApiService {

    @GET("software/acromine/dictionary.py")
    suspend fun getAcronymList(@Query("sf") sf: String) : MutableList<AcronymResponse>

}
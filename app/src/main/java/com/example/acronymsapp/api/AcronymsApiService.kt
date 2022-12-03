package com.example.acronymsapp.api

import com.example.acronymsapp.data.AcronymResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymsApiService {

    @GET("software/acromine/dictionary.py")
    suspend fun getAcronymList(@Query("sf") sf: String) : Response<MutableList<AcronymResponse>>

}
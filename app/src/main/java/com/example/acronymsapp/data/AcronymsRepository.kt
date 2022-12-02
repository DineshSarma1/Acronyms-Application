package com.example.acronymsapp.data

import retrofit2.Response
import retrofit2.http.Query

interface AcronymsRepository {

    suspend fun getAcronymList(sf: String) : Response<MutableList<AcronymResponse>>

}
package com.example.acronymsapp.data

import com.example.acronymsapp.util.NetworkState
import retrofit2.Response
import retrofit2.http.Query

interface AcronymsRepository {

    suspend fun getAcronymList(sf: String) : NetworkState<MutableList<AcronymResponse>>

}
package com.example.acronymsapp.repository

import com.example.acronymsapp.data.AcronymResponse
import com.example.acronymsapp.util.NetworkState

interface AcronymsRepository {

    suspend fun getAcronymList(sf: String) : NetworkState<MutableList<AcronymResponse>>

}
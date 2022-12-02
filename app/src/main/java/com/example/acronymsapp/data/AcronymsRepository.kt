package com.example.acronymsapp.data

import com.example.acronymsapp.util.NetworkState

interface AcronymsRepository {

    suspend fun getAcronymList(sf: String) : NetworkState<MutableList<AcronymResponse>>

}
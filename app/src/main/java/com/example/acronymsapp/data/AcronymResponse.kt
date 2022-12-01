package com.example.acronymsapp.data

data class AcronymResponse(
    val sf: String,
    val lfd: MutableList<FullForm>
)

data class FullForm(
    val lf: String,
    val freq: Int,
    val since: Int,
    val vars: MutableList<Variation>
)

data class Variation(
    val lf: String,
    val freq: Int,
    val since: Int
)

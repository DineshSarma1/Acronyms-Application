package com.example.acronymsapp.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AcronymResponseTest {

    private lateinit var acronymResponse: AcronymResponse

    @Before
    fun setup() {

        acronymResponse = AcronymResponse("HMM", mutableListOf(
            FullForm("heavy meromyosin", 267, 1971, mutableListOf(
                Variation("heavy meromyosin", 244, 1971),
                Variation("Heavy meromyosin", 12, 1975)
            )),
            FullForm("hidden Markov model", 267, 1971, mutableListOf(
                Variation("hidden Markov model", 148, 1971),
                Variation("hidden Markov model", 29, 1975)
            ))
        ))


    }

    @Test
    fun `get full form data check mapping_should return valid fullForm`() {
        val fullForm = acronymResponse.lfd[0].lf
        val expectedResult = "heavy meromyosin"
        assertEquals(expectedResult, fullForm)
    }
}
package com.example.acronymsapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.acronymsapp.repository.AcronymsRepository
import com.example.acronymsapp.repository.AcronymsRepositoryImpl
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    lateinit var repository: AcronymsRepository
    lateinit var viewModel: HomeViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        repository = mockk<AcronymsRepositoryImpl>()
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun `test Loading Status After Search Button Click - LiveDataChanged` () {

        //initially loading value is false

        //loading value should be true after button click
        viewModel.onSearchButtonClicked()

        assertEquals(true, viewModel.loading.value)
    }

}
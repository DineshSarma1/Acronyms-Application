package com.example.acronymsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @BindValue
    @JvmField
    val viewModel = mockk<HomeViewModel>(relaxed = true)

    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        every { viewModel.errorMessage } returns errorMessage
        every { viewModel.loading } returns loading
    }

}
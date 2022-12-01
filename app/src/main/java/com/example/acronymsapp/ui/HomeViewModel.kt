package com.example.acronymsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronymsapp.data.AcronymResponse
import com.example.acronymsapp.data.AcronymsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AcronymsRepository
) : ViewModel(){

    private val _data: MutableLiveData<List<AcronymResponse>> = MutableLiveData()
    val data: LiveData<List<AcronymResponse>> = _data

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _data.postValue(repository.getAcronymList("HMM"))
        }
    }

}
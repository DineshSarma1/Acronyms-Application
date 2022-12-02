package com.example.acronymsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acronymsapp.data.AcronymResponse
import com.example.acronymsapp.data.AcronymsRepository
import com.example.acronymsapp.util.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.net.UnknownServiceException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AcronymsRepository
) : ViewModel() {

    //Api Live Data
    private val _data: MutableLiveData<List<AcronymResponse>> = MutableLiveData()
    val data: LiveData<List<AcronymResponse>> get() = _data

    //Error message
    private val _errorMessage = MutableLiveData<String>()
    //val errorMessage: LiveData<String> get() = _errorMessage

    //loading state
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    //input value
    var acronym = MutableLiveData<String>()

    init {
        _loading.value = false
    }

    private fun loadData(input: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val response = repository.getAcronymList(input)) {

                    is NetworkState.Success -> {
                        _data.postValue(response.data!!)
                    }

                    is NetworkState.Error -> {
                        onError("Error: ${response.response.message()}")
                    }
                }
            }catch (e: UnknownServiceException) {
                Log.e(TAG,"Error: ${e.message}")
            }
        }
    }

    fun onSearchButtonClicked() {
        //enabling progress bar
        _loading.value = true

        val input = acronym.value
        input?.let {
            loadData(it)
        }
    }

    private fun onError(message: String) {
        _errorMessage.value = message
        _loading.value = false

        //logging error message
        Log.e(TAG, message)
    }

    companion object {
        val TAG = HomeViewModel::class.simpleName
    }

}
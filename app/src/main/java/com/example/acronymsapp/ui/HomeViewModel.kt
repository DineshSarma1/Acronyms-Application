package com.example.acronymsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acronymsapp.data.AcronymResponse
import com.example.acronymsapp.data.AcronymsRepository
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
    val data: LiveData<List<AcronymResponse>> = _data

    //Error message
    var errorMessage = MutableLiveData<String>()

    //loading state
    var loading = MutableLiveData<Boolean>()

    //input value
    var acronym = MutableLiveData<String>()

    //to handle Jobs
    private var job: Job? = null

    init {
        loading.value = false
    }

    private fun loadData(input: String) {
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.getAcronymList(input)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _data.postValue(response.body())
                        loading.value = false
                    } else {
                        onError("Error: ${response.message()}")
                    }
                }
            }catch (e: UnknownServiceException) {
                Log.e(TAG,"Error: ${e.message}")
            }
        }
    }

    fun onSearchButtonClicked() {
        //enabling progress bar
        loading.value = true

        val input = acronym.value
        input?.let {
            loadData(it)
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false

        //logging error message
        Log.e(TAG, message)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    companion object {
        val TAG = HomeViewModel::class.simpleName
    }

}
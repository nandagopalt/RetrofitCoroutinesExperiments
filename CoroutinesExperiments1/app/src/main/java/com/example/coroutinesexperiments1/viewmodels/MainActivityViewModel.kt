package com.example.coroutinesexperiments1.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel(countParam: Int, messageParam: String): ViewModel() {
    private var countLiveData = MutableLiveData<Int>()
    val count: LiveData<Int>
    get() = countLiveData

    private var messageLiveData = MutableLiveData<String>()
    val message: LiveData<String>
    get() = messageLiveData

    init {
        println("MainActivityViewModel init called !")
        println("Initial values from view controller : $countParam and $messageParam")
        countLiveData.value = countParam
        messageLiveData.value = messageParam
    }

   /* fun getInitialCount(): Int {
        return count
    }*/

    // Unit -> No return type
    fun incrementCount(): Unit {
        countLiveData.value = countLiveData.value?.plus(1)
    }

     fun startDownload() {
        Log.i("MainActivityViewModel", "Starting download from ${Thread.currentThread().name}")
        CoroutineScope(Dispatchers.IO).launch {
            for(i in 1..200000) {
                delay(100)
                //Log.i("MainActivityViewModel", "Downloading $i from ${Thread.currentThread().name}")
                withContext(Dispatchers.Main) {
                    messageLiveData.value = "Downloading $i from ${Thread.currentThread().name}"
                }
            }
        }

    }
}
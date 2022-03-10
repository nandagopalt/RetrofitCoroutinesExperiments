package com.amalwin.coroutinesexperiments3

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    private val countMutableLiveData = MutableLiveData<Int>()
    private val downloadCountLiveData = MutableLiveData<String>()
    val countLiveData: LiveData<Int>
        get() = countMutableLiveData
    val downloadLiveData: LiveData<String>
        get() = downloadCountLiveData

    init {
        countMutableLiveData.value = 0
        downloadCountLiveData.value = ""
    }

    fun incrementCount() {
        countMutableLiveData.value = countMutableLiveData.value?.plus(1)
    }

    suspend fun incrementDownloadCount() {
        for (i in 1..5000) {
            delay(500)
            downloadCountLiveData.value = "Downloading $i in ${Thread.currentThread().name}"
        }
    }

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("MYTAG", "ViewModel cleared !")
    }

    suspend fun getUserStock1(): Int {
        delay(10000)
        Log.i("MYTAG", "Stock 1 returned !")
        return 50000
    }

    suspend fun getUserStock2(): Int {
        delay(11000)
        Log.i("MYTAG", "Stock 2 returned !")
        return 11000
    }
}
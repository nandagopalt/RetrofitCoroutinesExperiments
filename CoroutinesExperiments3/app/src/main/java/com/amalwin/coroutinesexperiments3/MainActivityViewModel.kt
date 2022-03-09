package com.amalwin.coroutinesexperiments3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val countMutableLiveData = MutableLiveData<Int>()
    val countLiveData: LiveData<Int>
        get() = countMutableLiveData

    init {
        countMutableLiveData.value = 0
    }

    fun incrementCount() {
        countMutableLiveData.value = countMutableLiveData.value?.plus(1)
    }

}
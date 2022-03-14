package com.amalwin.coroutinesexperiments3

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class UserViewModel : ViewModel() {
    //private val myJob = Job()
    //private val myCoroutineScope = CoroutineScope(Dispatchers.IO + myJob)

    private val userRepository: UserRepository = UserRepository()
    private val userListMutableLiveData: MutableLiveData<List<User>>
    val userListLiveData: LiveData<List<User>>
        get() = userListMutableLiveData

    private lateinit var deferredUserList: Deferred<List<User>>
    private lateinit var deferredUserCount: Deferred<Int>

    init {
        Log.i("MYTAG", "UserViewModel / ViewModel init called !")
        userListMutableLiveData = MutableLiveData()
    }

    suspend fun getUserData() {
        /*myCoroutineScope.launch {
             Log.i("MYTAG", "Execution started from ${Thread.currentThread().name}")
             for (i in 1..5000) {
                 delay(100)
                 Log.i("MYTAG", "Execution running $i")
             }
             Log.i("MYTAG", "Execution completed from ${Thread.currentThread().name}")
         }*/

        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.i("MYTAG", "Execution started from ${Thread.currentThread().name}")
                for (i in 1..5000) {
                    delay(100)
                    Log.i("MYTAG", "Execution running $i")
                }
                Log.i("MYTAG", "Execution completed from ${Thread.currentThread().name}")
            } catch (exception: Exception) {
                Log.i("MYTAG", exception.toString())
            }
        }

       /* coroutineScope {
            viewModelScope.launch {
                Log.i("MYTAG", "Execution started from ${Thread.currentThread().name}")
                /*launch(Dispatchers.IO) {
                    Log.i("MYTAG", "Execution happening from ${Thread.currentThread().name}")
                    userListMutableLiveData.postValue(userRepository.getUserListV1())
                }*/
                deferredUserList = async(Dispatchers.IO) {
                    Log.i("MYTAG", "Execution happening from ${Thread.currentThread().name}")
                    userRepository.getUserListV1()
                }
                userListMutableLiveData.value = deferredUserList.await()
            }
        }*/
    }

    /*override fun onCleared() {
         super.onCleared()
         Log.i("MYTAG", "UserViewModel / ViewModel cleared !")
         myJob.cancel()
         myCoroutineScope.cancel()
         //job.cancel()
     }*/
}
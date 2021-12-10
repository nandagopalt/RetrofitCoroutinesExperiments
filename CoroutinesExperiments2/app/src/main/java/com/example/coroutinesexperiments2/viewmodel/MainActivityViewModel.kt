package com.example.coroutinesexperiments2.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.coroutinesexperiments2.model.User
import com.example.coroutinesexperiments2.model.UserRepository
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    private val userRepository = UserRepository()
    private var usersList: List<User>? = null

    private var usersListMutableLiveData = MutableLiveData<List<User>>()
    val usersListLiveData: LiveData<List<User>>
        get() = usersListMutableLiveData

    private val myJob = Job()
    private val myCoroutineScope = CoroutineScope(Dispatchers.IO + myJob)

    init {
        println("MainActivityViewModel init block called...")
    }

     var users = liveData(Dispatchers.IO) {
        usersList = userRepository.getUsersList()
        emit(usersList)
    }

     fun getUsers() {
         var usersList: List<User>? = null
        viewModelScope.launch {
           withContext(Dispatchers.IO) {
               Log.i("Users", "Fetching from ${Thread.currentThread().name}")
                usersList = userRepository.getUsersList()
            }
            usersListMutableLiveData.value = usersList!!
        }
    }

    suspend fun getUsersCount(): Int {
        var count = 0
        val deferred = myCoroutineScope.async {
            // write the code for launching the coroutine and executing the tasks
            Log.i("Stock", "Calculating from ${Thread.currentThread().name}")
            delay(5000)
            count = 50
            Log.i("Stock", "Returning the value")
            return@async count
        }
        return deferred.await()
    }

    // Called when the viewmodel get cleared
    override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }
}
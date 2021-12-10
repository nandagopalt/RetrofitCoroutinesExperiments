package com.example.coroutinesexperiments2.model

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager2 {
    var count = 0
    lateinit var deferred: Deferred<Int>
    /* 1. Launch more than one coroutine and to ensure all the tasks/coroutine created inside the coroutine scope
          gets completed before the return of the suspending function.
       2. "coroutineScope" suspending function creates/launches the child coroutine scope and the parent coroutine
          scope from the view controllers takes the control of the created child coroutine scope
       3. If Dispatchers are not mentioned in the child coroutine created from the "coroutineScope" then the parent
          Dispatchers scope will be considered

     */
    suspend fun getTotalUsersCount(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(5000)
                Log.i("Stock", "Calculating task 1 from ${Thread.currentThread().name}")
                count = 50
            }
            deferred = async(Dispatchers.IO) {
                delay(5000)
                Log.i("Stock", "Calculating task 2 from ${Thread.currentThread().name}")
                return@async 50
            }
        }
        Log.i("Stock", "Returning value from ${Thread.currentThread().name}")
        return count + deferred.await();
    }
}
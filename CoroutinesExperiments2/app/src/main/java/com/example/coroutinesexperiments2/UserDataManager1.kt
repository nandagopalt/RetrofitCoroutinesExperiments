package com.example.coroutinesexperiments2

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager1 {
    private var count = 0
    suspend fun getUserCount():Int {
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            count = 50
            Log.i("Stock", "Count from ${Thread.currentThread().name} is $count")
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(10000)
            Log.i("Stock", "Count returning from Async Coroutine Builder! by ${Thread.currentThread().name}")
            return@async 50
        }
        return count + deferred.await()
    }
}
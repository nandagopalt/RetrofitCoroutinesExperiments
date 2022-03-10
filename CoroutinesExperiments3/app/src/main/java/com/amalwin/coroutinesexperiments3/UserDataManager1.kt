package com.amalwin.coroutinesexperiments3

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager1 {
    private var count = 0

    // Unstructured concurrency : Doesn't guarantees the execution/completion of the all the tasks of the suspending function before
    // the control returns to the caller function
    fun getUserCountV1(): Int {
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            count = 50
        }
        return count
    }

    // Structured concurrency : Guarantees the completion of all the tasks in the child coroutine scope started
    // from the parent coroutine
    suspend fun getUserCountV2(): Int {
        var deferredCountInt: Deferred<Int>
        Log.i("MYTAG", "Calculation started !")
        coroutineScope {
            launch(Dispatchers.IO) {
                Log.i("MYTAG", "Executing the launch builder !")
                delay(5000)
                Log.i("MYTAG", "Returning the count from launch builder !")
                count = 20
            }
            deferredCountInt = async(Dispatchers.IO) {
                Log.i("MYTAG", "Executing the async builder !")
                delay(10000)
                Log.i("MYTAG", "Returning the count from async builder !")
                return@async 30
            }
        }
        return count + deferredCountInt.await()
    }

}
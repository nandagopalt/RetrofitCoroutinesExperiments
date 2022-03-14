package com.amalwin.coroutinesexperiments3

import android.util.Log
import kotlinx.coroutines.*

class UserDataManager1 {
    private var count = 0

    // Unstructured concurrency
    /* 1. Doesn't guarantees the execution/completion of the all the tasks of the suspending function before
       the control returns to the caller function.
       2. Child coroutine may be still be running even after the completion of the parent coroutine and it may cause unpredictable errors especially
       with launch coroutine builder.
       3. There is no proper way to handle the exceptions thrown via the unstructured concurrency.
     */
    suspend fun getUserCountV1(): Int {
        val deferredCountInt: Deferred<Int>
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            count = 50
        }

        deferredCountInt = CoroutineScope(Dispatchers.IO).async {
            delay(5000)
            return@async 70
        }
        return count + deferredCountInt.await()
    }

    // Structured concurrency
    /* 1. Guarantees the completion of all the tasks in the child coroutine scope started
    from the parent coroutine
       2. coroutineScope: Suspending function allows creating the child coroutine scope with in the given coroutine scope
       3. Possible to cancel the coroutine and manage effectively
       */
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
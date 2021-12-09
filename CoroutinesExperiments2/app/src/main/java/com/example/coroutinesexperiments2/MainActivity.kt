package com.example.coroutinesexperiments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Serial decomposition and Parallel decomposition
        /*
        1. Create a CoroutineScope with the given context Dispatchers.IO. This means the coroutines that gets
        created is associated to background thread from the pool of IO threads unblocking the current main thread.
        2. What is CoroutineScope ?
           CoroutineScope is an Interface that provides the scope of the coroutines based on the context attached
           as the constructor parameter
        3. Launch coroutine builder launches the coroutine with no response i.e, it returns the coroutine reference wrapped
           with the job instance. Using the launch, there is no return value / computational resuot from the launch builder
         */

        // Structured concurrency : Switching from Main thread to IO thread
        // Log.i("Stock","Before launch: ${Thread.currentThread().name}")
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("Stock", "Calculation started...")
            // serialDecomposition()
            // parallelDecomposition()
            val count = UserDataManager1().getUserCount()
            Toast.makeText(
                applicationContext, "User Count : $count",
                Toast.LENGTH_LONG
            ).show()
            Log.i("Stock", "Count: $count")
        }
    }

    private suspend fun serialDecomposition() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.i(
                "Stock",
                "Stock counting (Inside coroutine launch) Task execution from ${Thread.currentThread().name}"
            )
            val result1 = getStockCount1()
            Log.i("Stock", "Received stock count 1: $result1")
            val result2 = getStockCount2()
            Log.i("Stock", "Received stock count 2: $result2")
            val result = result1 + result2
            Log.i("Stock", "Stock count:${result}")
        }
    }

    private suspend fun parallelDecomposition() {
        CoroutineScope(Dispatchers.Main).launch {
            //Log.i(
            //   "Stock",
            //    "Stock counting (Inside coroutine launch) Task execution from ${Thread.currentThread().name}"
            //)
            val result1 = async(Dispatchers.IO) { getStockCount1() }
            //Log.i("Stock", "Received stock count 1: ${result1.await()}")
            val result2 = async(Dispatchers.IO) { getStockCount2() }
            //Log.i("Stock", "Received stock count 2: ${result2.await()}")
            val result = result1.await() + result2.await()
            Log.i("Stock", "Stock count:${result}")
            Toast.makeText(applicationContext, "Stock count:${result}", Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun getStockCount1(): Int {
        delay(10000)
        Log.i("Stock", "(Inside getStockCount1) Task execution from ${Thread.currentThread().name}")
        Log.i("Stock", "Returning Stock 1")
        return 5500
    }

    private suspend fun getStockCount2(): Int {
        delay(12000)
        Log.i("Stock", "(Inside getStockCount2) Task execution from ${Thread.currentThread().name}")
        Log.i("Stock", "Returning Stock 2")
        return 11000
    }
}
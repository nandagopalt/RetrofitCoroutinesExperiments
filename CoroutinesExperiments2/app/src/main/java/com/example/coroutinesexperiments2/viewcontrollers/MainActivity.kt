package com.example.coroutinesexperiments2.viewcontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexperiments2.R
import com.example.coroutinesexperiments2.databinding.ActivityMainBinding
import com.example.coroutinesexperiments2.model.User
import com.example.coroutinesexperiments2.model.UserDataManager2
import com.example.coroutinesexperiments2.viewmodel.MainActivityViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycle", "Activity onCreate called...")
        mainActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        mainActivityDataBinding.progressBar2.visibility = View.VISIBLE
        Log.i("Users", "Loading the users....")
        //mainActivityViewModel.getUsers()

        /*CoroutineScope(Dispatchers.Main).launch {
            mainActivityViewModel.getUsers()
            mainActivityDataBinding.apply {
                progressBar2.visibility = View.INVISIBLE
                txtLabel.text = "Completed"
            }
        }*/

        mainActivityViewModel.usersListLiveData.observe(this, Observer { usersList ->
            usersList.forEach { user ->
                Log.i("LifeCycle", "${user.id}, ${user.name}")
            }
            mainActivityDataBinding.apply {
                progressBar2.visibility = View.INVISIBLE
                txtLabel.text = "Completed"
            }
        })

        mainActivityViewModel.users.observe(this, Observer { usersList ->
            usersList?.forEach { user ->
                Log.i("LifeCycle", "${user.id}, ${user.name}")
            }
            mainActivityDataBinding.apply {
                progressBar2.visibility = View.INVISIBLE
                txtLabel.text = "Completed"
            }
        })


        /*Log.i("Stock", "Starting the calculation...")
        CoroutineScope(Dispatchers.Main).launch {
            mainActivityDataBinding.apply {
                txtLabel.text = mainActivityViewModel.getUsersCount().toString()
                progressBar2.visibility = View.INVISIBLE
            }
        }*/

        lifecycleScope.launchWhenCreated {
            Log.i("LifeCycle", "Creation from lifeCycleScope")
        }

        lifecycleScope.launchWhenResumed {
            Log.i("LifeCycle", "Resumed from lifeCycleScope")
        }

        lifecycleScope.launchWhenStarted {
            Log.i("LifeCycle", "Started from lifeCycleScope")
        }


        // mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        // DataBindingUtil.setContentView(this, R.layout.activity_main)
        // setContentView(mainActivityBinding.root)

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


        /*CoroutineScope(Dispatchers.Main).launch {
            Log.i("Stock", "Calculation started...")
            // serialDecomposition()
            // parallelDecomposition()
            //val count = UserDataManager1().getUserCount()
            val count = UserDataManager2().getTotalUsersCount()
            Toast.makeText(
                applicationContext, "User Count : $count",
                Toast.LENGTH_LONG
            ).show()
            Log.i("Stock", "Count: $count")
        }*/
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle", "Activity onResume called...")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "Activity onStart called...")
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
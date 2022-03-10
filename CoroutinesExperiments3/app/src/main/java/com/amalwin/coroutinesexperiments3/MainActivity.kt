package com.amalwin.coroutinesexperiments3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amalwin.coroutinesexperiments3.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityViewModel: MainActivityViewModel
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MYTAG", "onCreate " + this.applicationContext + "," + this)

        activityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        /*activityViewModel.countLiveData.observe(this) {
            binding.txtCount.text = it.toString()
        }*/

        activityViewModel.downloadLiveData.observe(this) {
            binding.downloadCount.text = it.toString()
        }

        binding.downloadButton.setOnClickListener {
            Log.i("MYTAG", "Download data button clicked !")
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserInformation()
            }
        }

        binding.btnCompleted.setOnClickListener {
            finish()
        }

        binding.incrementButton.setOnClickListener {
            Log.i("MYTAG", "Increment button clicked !")
            //activityViewModel.incrementCount()
            // binding.txtCount.text = UserDataManager1().getUserCountV1().toString()
            CoroutineScope(Dispatchers.Main).launch {
                binding.txtCount.text = UserDataManager1().getUserCountV2().toString()
            }
        }
    }

    private suspend fun downloadUserInformation() {
        //withContext(Dispatchers.Main) {
        //for (i in 1..50000) {
        //  delay(10)
        //Log.i("MYTAG", "Thread downloading $i in ${Thread.currentThread().name}")
        //binding.downloadCount.text =
        //"Thread downloading $i in ${Thread.currentThread().name}"

        //activityViewModel.incrementDownloadCount()

        //}

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MYTAG", "Calculation Started !")
            val stock1 = async(Dispatchers.IO) { activityViewModel.getUserStock1() }
            val stock2 = async(Dispatchers.IO) { activityViewModel.getUserStock2() }
            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_LONG).show()
            //Log.i("MYTAG", "Total is $total")
        }
    }


    private fun updateCount() {
        Log.i("MYTAG", "Thread running from ${Thread.currentThread().name}")
        binding.txtCount.text = count++.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "onRestart" + this.applicationContext + "," + this)
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "onDestroy")
    }

}
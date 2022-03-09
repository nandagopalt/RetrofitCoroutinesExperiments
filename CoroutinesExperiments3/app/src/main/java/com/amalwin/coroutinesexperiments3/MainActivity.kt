package com.amalwin.coroutinesexperiments3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amalwin.coroutinesexperiments3.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        activityViewModel.countLiveData.observe(this, Observer {
            binding.txtCount.text = it.toString()
        })

        binding.downloadButton.setOnClickListener {
            Log.i("MYTAG", "Download data button clicked !")
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserInformation()
            }
        }

        binding.incrementButton.setOnClickListener {
            Log.i("MYTAG", "Increment button clicked !")
            activityViewModel.incrementCount()
        }
    }

    private fun downloadUserInformation() {
        for (i in 1..50000) {
            Log.i("MYTAG", "Thread downloading $i in ${Thread.currentThread().name}")
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
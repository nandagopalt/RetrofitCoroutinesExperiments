package com.amalwin.coroutinesbyexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amalwin.coroutinesbyexample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCount.setOnClickListener {
            binding.tvCounter.text = count++.toString()
        }

        binding.btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("MyTag", "Click event handled from ${Thread.currentThread().name}")
                downloadUserData()
            }
        }
    }

    suspend fun downloadUserData() {
        for (i in 1..100000) {
            withContext(Dispatchers.Main) {
                //Log.i("MyTag", "Downloading user $i from ${Thread.currentThread().name}")
                binding.tvMessageCounter.text = "Downloading user $i from ${Thread.currentThread().name}"
            }
        }
    }

}
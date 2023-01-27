package com.amalwin.coroutinesbyexample1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            //for (i in 1..100000)
            //  Log.i("MainActivity", "Downloading $i in ${Thread.currentThread().name}")
            Log.i("MyTag", "Hello from ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag", "Hello from ${Thread.currentThread().name}")
        }
    }


}
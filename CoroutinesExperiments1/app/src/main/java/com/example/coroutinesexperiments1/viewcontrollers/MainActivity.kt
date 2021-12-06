package com.example.coroutinesexperiments1.viewcontrollers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinesexperiments1.databinding.ActivityMainBinding
import com.example.coroutinesexperiments1.viewmodels.MainActivityViewModel
import com.example.coroutinesexperiments1.viewmodels.MainActivityViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Getting the binding instance through view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModelFactory = MainActivityViewModelFactory(100, "Welcome")
        mainActivityViewModel = ViewModelProvider(this, mainActivityViewModelFactory)[(MainActivityViewModel::class.java)]
        //binding.txtIncrementLabel.text = mainActivityViewModel.getInitialCount().toString()
        binding.myViewModel = mainActivityViewModel
        binding.lifecycleOwner = this
        /*mainActivityViewModel.count.observe(this, Observer { number ->
            binding.txtIncrementLabel.text = number.toString()
        })
        mainActivityViewModel.message.observe(this, Observer { message ->
            binding.txtLabelDownload.text = message
        })*/

        binding.apply {
        /* btnDownload.setOnClickListener {
            txtLabelDownload.text = mainActivityViewModel.startDownload()
        }*/
        /* btnIncrement.setOnClickListener {
            txtIncrementLabel.text = mainActivityViewModel.incrementCount().toString()
        }*/
        }

        // TODO: Making the coroutine to run in the background thread
        // 1. Create simple coroutine using the "CoroutineScope" Interface
        // 2. Define the "coroutine context" to be "Dispatchers.IO" -> This will ensure the
        // created coroutines to be executed in the background thread from the pool of IO thread
        // 3. Use the "launch" coroutine builder to launch the coroutine without blocking the current thread
        // and returns the reference of coroutine as instance of the Job.
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MySimpleCoroutine", "Coroutine executed : ${Thread.currentThread().name}")
        }

        // TODO: Making the coroutine to execute in the main thread
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MySimpleCoroutine", "Coroutine executed : ${Thread.currentThread().name}")
        }

    }

}
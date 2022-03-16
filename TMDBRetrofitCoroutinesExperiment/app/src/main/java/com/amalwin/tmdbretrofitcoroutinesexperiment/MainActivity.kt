package com.amalwin.tmdbretrofitcoroutinesexperiment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MYTAG"
    // ViewBinding to get the view references in the lifecycle objects from the XML layout file
    //private lateinit var viewBinding: ActivityMainBinding

    // Inflating the layout using DataBindingUtil
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding = ActivityMainBinding.inflate(layoutInflater)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(viewBinding.root)

        dataBinding.movieButton.setOnClickListener {
            Log.i(TAG, "Movie Button Clicked !")
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        dataBinding.artistButton.setOnClickListener {
            Log.i(TAG, "Artist Button Clicked !")
            val intent = Intent(this, ActorActivity::class.java)
            startActivity(intent)
        }

        dataBinding.tvButton.setOnClickListener {
            Log.i(TAG, "TV Show Button Clicked ! ")
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.amalwin.tmdbretrofitcoroutinesexperiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        //setContentView(R.layout.activity_movie)
        binding.movieTitle.text = "Movie"
    }
}
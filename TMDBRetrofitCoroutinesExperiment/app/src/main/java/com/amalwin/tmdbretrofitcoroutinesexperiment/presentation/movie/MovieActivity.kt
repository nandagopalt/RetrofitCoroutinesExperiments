package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityMovieBinding
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core.Injector
import javax.inject.Inject


class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        //setContentView(R.layout.activity_movie)
        binding.movieTitle.text = "Movie"
       (application as Injector).createMovieSubcomponent().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        val movieList = movieViewModel.getMovies()
        movieList.observe(this, Observer { movies ->
            movies?.forEach { movieItem ->
                Log.i("MYTAG", movieItem.toString())
            }
        })
    }
}
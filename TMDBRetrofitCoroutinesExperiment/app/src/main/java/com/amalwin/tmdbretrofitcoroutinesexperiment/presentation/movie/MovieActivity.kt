package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.movie

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityMovieBinding
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core.Injector
import javax.inject.Inject


class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var movieAdapter: MovieRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        //setContentView(R.layout.activity_movie)
        binding.movieTitle.text = "Movie"
       (application as Injector).createMovieSubcomponent().inject(this)
        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]
        initializeRecyclerView()
    }

    fun initializeRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieRecyclerAdapter()
        binding.movieRecyclerView.adapter = movieAdapter
        fetchMovieList()
    }

    fun fetchMovieList() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val movieList = movieViewModel.getMovies()
        movieList.observe(this, Observer { movies ->
           /* movies?.forEach { movieItem ->
                Log.i("MYTAG", movieItem.toString())
            }*/
            if(movies != null) {
                movieAdapter.setMovieList(movies)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data found !", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
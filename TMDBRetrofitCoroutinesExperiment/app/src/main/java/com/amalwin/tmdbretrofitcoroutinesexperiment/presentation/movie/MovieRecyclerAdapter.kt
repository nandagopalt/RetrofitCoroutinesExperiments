package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.movie.Movie
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieRecyclerAdapter() : RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setMovieList(movieList: List<Movie>) {
        this.movieList.clear()
        this.movieList.addAll(movieList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.movieTitle.text = movie.title
        binding.movieDescription.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
        Glide.with(binding.movieImage.context).load(posterURL).into(binding.movieImage)
    }
}
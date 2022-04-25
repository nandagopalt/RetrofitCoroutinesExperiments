package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbretrofitcoroutinesexperiment.BuildConfig
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.tvshow.TVShow
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TVShowAdapter constructor() : RecyclerView.Adapter<TVShowViewHolder>() {
    private lateinit var tvShowList: ArrayList<TVShow>

    fun setTVShowList(tvShowList: List<TVShow>) {
        this.tvShowList.clear()
        this.tvShowList.addAll(tvShowList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context);
        val listItemBinding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return TVShowViewHolder(listItemBinding);
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShowList[position]);
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class TVShowViewHolder(private val listItemBinding: ListItemBinding) :
    RecyclerView.ViewHolder(listItemBinding.root) {
    fun bind(tvShow: TVShow) {
        listItemBinding.apply {
            movieTitle.text = tvShow.name
            movieDescription.text = tvShow.overview
        }
        val tvShowURL = BuildConfig.IMAGE_URL + tvShow.posterPath
        Glide.with(listItemBinding.movieImage.context).load(tvShowURL)
            .into(listItemBinding.movieImage)
    }
}
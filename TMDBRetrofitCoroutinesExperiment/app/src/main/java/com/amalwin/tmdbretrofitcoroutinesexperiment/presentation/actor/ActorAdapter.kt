package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.actor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbretrofitcoroutinesexperiment.BuildConfig
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.data.model.actor.Actor
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>() {
    private lateinit var actorList: ArrayList<Actor>

    fun setActorList(actorList: List<Actor>) {
        this.actorList.clear()
        this.actorList.addAll(actorList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return ActorViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actorList[position])
    }

    override fun getItemCount(): Int {
        return actorList.size
    }
}

class ActorViewHolder(private val listItemBinding: ListItemBinding) :
    RecyclerView.ViewHolder(listItemBinding.root) {
    fun bind(actor: Actor) {
        listItemBinding.apply {
            this.movieTitle.text = actor.name
        }
        val imageURL = BuildConfig.IMAGE_URL + actor.profilePath
        Glide.with(listItemBinding.movieImage.context).load(imageURL)
            .into(listItemBinding.movieImage)
    }
}

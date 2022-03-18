package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.actor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityActorBinding

class ActorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actor)
        //setContentView(R.layout.activity_actor)
        binding.actorTitle.text = "Actor"
    }
}
package com.amalwin.tmdbretrofitcoroutinesexperiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        //setContentView(R.layout.activity_tvshow)
        binding.tvShowTitle.text = "TV Show"
    }
}
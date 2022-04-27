package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityTvshowBinding
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core.Injector
import javax.inject.Inject

class TVShowActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TVShowViewModelFactory
    private lateinit var tvShowViewModel: TVShowViewModel
    private lateinit var binding: ActivityTvshowBinding
    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        //setContentView(R.layout.activity_tvshow)
        binding.tvShowTitle.text = "TV Show"
        (application as Injector).createTVShowSubComponent().inject(this)
        tvShowViewModel =
            ViewModelProvider(this, tvShowViewModelFactory)[TVShowViewModel::class.java]
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TVShowAdapter()
        binding.tvShowRecyclerView.adapter = tvShowAdapter
        fetchTVShowList()
    }

    private fun fetchTVShowList() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val tvShowLiveData = tvShowViewModel.getTVShows()
        tvShowLiveData.observe(this) { tvShow ->
            if (tvShow != null) {
                tvShowAdapter.setTVShowList(tvShow)
                tvShowAdapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data found !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh -> {
                fetchTVShowList()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
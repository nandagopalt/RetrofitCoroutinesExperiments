package com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.actor

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalwin.tmdbretrofitcoroutinesexperiment.R
import com.amalwin.tmdbretrofitcoroutinesexperiment.databinding.ActivityActorBinding
import com.amalwin.tmdbretrofitcoroutinesexperiment.presentation.di.core.Injector
import javax.inject.Inject

class ActorActivity : AppCompatActivity() {
    @Inject
    lateinit var actorViewModelFactory: ActorViewModelFactory
    private lateinit var actorViewModel: ActorViewModel
    private lateinit var actorAdapter: ActorAdapter
    private lateinit var binding: ActivityActorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actor)
        //setContentView(R.layout.activity_actor)
        binding.actorTitle.text = "Actor"
        (application as Injector).createActorSubComponent().inject(this)
        actorViewModel = ViewModelProvider(this, actorViewModelFactory)[ActorViewModel::class.java]
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        binding.actorRecyclerView.layoutManager = LinearLayoutManager(this)
        actorAdapter = ActorAdapter()
        binding.actorRecyclerView.adapter = actorAdapter
        fetchActorList()
    }

    fun fetchActorList() {
        binding.actorRecyclerView.visibility = View.VISIBLE
        val actorsLiveData = actorViewModel.getActors()
        actorsLiveData.observe(this) { actors ->
            if (actors != null) {
                actorAdapter.setActorList(actors)
                actorAdapter.notifyDataSetChanged()
                binding.actorProgressBar.visibility = View.GONE
            } else {
                binding.actorProgressBar.visibility = View.GONE
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
                fetchActorList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
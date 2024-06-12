package com.amalwintechnologies.retrofitcoroutinesexample2.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalwintechnologies.retrofitcoroutinesexample2.databinding.ActivityMainBinding
import com.amalwintechnologies.retrofitcoroutinesexample2.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    private lateinit var binding: ActivityMainBinding
    private val countriesListAdapter = CountryListAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CountryViewModel::class.java]
        viewModel.refresh()

        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = countriesListAdapter
        }

        viewModel.mutableCountriesList.observe(this, Observer { it ->
            it.let { countries ->
                countriesListAdapter.updateCountries(countries)
               /* for (country in countries) {
                    println(country)
                }*/
            }

        })

        viewModel.isLoadingMutableLiveData.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            if (it) {
                binding.apply {
                    message.visibility = View.GONE
                    //recyclerView.visibility = View.GONE
                }
            }
        }

        viewModel.errorMutableLiveData.observe(this) { isError ->
            binding.message.visibility = if (isError.isNullOrBlank()) View.GONE else View.VISIBLE
        }
    }
}
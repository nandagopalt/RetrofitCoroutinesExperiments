package com.amalwintechnologies.retrofitcoroutinesexample2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amalwintechnologies.retrofitcoroutinesexample2.databinding.CountryItemBinding
import com.amalwintechnologies.retrofitcoroutinesexample2.model.Country
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class CountryListAdapter(private var countriesList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context))
        return CountryListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        countriesList.let {
            return it.size
        }
    }

    override fun onBindViewHolder(holder: CountryListViewHolder, position: Int) {
        val country = countriesList[position]
        holder.bind(country)
    }

    fun updateCountries(newCountriesList: List<Country>) {
        countriesList.clear()
        countriesList.addAll(newCountriesList)
        notifyDataSetChanged()
    }

    inner class CountryListViewHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.apply {
                countryName.text = country.countryName
                countryCapital.text = country.countryCapital
                Picasso.get().load(country.countryFlag).into(countryFlag)
                //Glide.with(binding.root.context).load(countryFlag).centerCrop().into(countryFlag)
            }
        }

    }
}
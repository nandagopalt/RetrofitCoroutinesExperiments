package com.amalwintechnologies.retrofitcoroutinesexample2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amalwintechnologies.retrofitcoroutinesexample2.model.Country
import com.amalwintechnologies.retrofitcoroutinesexample2.model.CountryResponse
import com.amalwintechnologies.retrofitcoroutinesexample2.model.CountryResponseItem
import com.amalwintechnologies.retrofitcoroutinesexample2.model.retrofit.CountriesAPI
import com.amalwintechnologies.retrofitcoroutinesexample2.model.retrofit.CountriesService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel : ViewModel() {
    private val TAG = "CountryViewModel"
    private var countriesService: CountriesAPI
    private var job: Job? = null

    val mutableCountriesList: MutableLiveData<List<Country>> =
         MutableLiveData<List<Country>>()
    val isLoadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val errorMutableLiveData: MutableLiveData<String?> = MutableLiveData<String?>()

    private val countryResponseItemList = arrayListOf<Country>()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            onError("Exception : ${throwable.localizedMessage}")
        }

    init {
        Log.d(TAG, "Inside init block of the CountryViewModel")
        countriesService = CountriesService.getCountriesService()
    }

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        isLoadingMutableLiveData.value = true

        job = CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            val response = countriesService.getCountriesResponse()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                        response.body()?.onEach { countryResponseItem ->
                            countryResponseItemList.add(
                                Country(
                                    countryResponseItem.name,
                                    countryResponseItem.capital,
                                    countryResponseItem.flagPNG
                                )
                            )
                        }
                    mutableCountriesList.value = countryResponseItemList
                    errorMutableLiveData.value = null
                    isLoadingMutableLiveData.value = false
                } else {
                    onError(response.message())
                }
            }
        }
    }

    private fun onError(message: String?) {
        Log.i(TAG, "Error : ${message.let { message }}")
        isLoadingMutableLiveData.value = false
        errorMutableLiveData.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}


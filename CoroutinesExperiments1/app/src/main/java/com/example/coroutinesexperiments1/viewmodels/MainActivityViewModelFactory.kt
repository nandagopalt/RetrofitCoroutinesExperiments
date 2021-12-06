package com.example.coroutinesexperiments1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val count: Int, private val message: String): ViewModelProvider.Factory {
   override fun <T: ViewModel> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
           return MainActivityViewModel(count,message) as T
       }
       throw IllegalArgumentException("View Model not found !")
   }
}
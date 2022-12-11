package com.example.weatherapp.ui.homePage

import TodayDatabaseDao
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomePageViewModelFactory(
    private val dataSource: TodayDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(HomePageViewModel::class.java)) {
//            return HomePageViewModel(dataSource, application) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
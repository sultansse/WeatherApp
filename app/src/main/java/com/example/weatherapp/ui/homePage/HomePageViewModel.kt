package com.example.weatherapp.ui.homePage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.weatherapp.data.repository.Repository
import com.example.weatherapp.ui.homePage.recyclers.TodayItem
import com.example.weatherapp.ui.homePage.recyclers.WeekItem
import kotlinx.coroutines.flow.combine

class HomePageViewModel/*(
    val database: TodayDatabaseDao,
    application: Application
)*/ : ViewModel()/*AndroidViewModel(application)*/ {

    private var _todayDataset: MutableLiveData<List<TodayItem>> = /*database.getAllTodays() todo*/
        MutableLiveData()
    val todayDataset: MutableLiveData<List<TodayItem>> get() = _todayDataset

    private var _weekDataset: MutableLiveData<List<WeekItem>> = MutableLiveData()
    val weekDataset: LiveData<List<WeekItem>> get() = _weekDataset

    private val repository = Repository.getInstance()

    val temperature = combine(
        repository.temperatureToday,
        repository.currentTemperatureType
    ) { temperature, type ->
        "$temperature${type.toFormattedString()}"
    }.asLiveData()



    init {
        loadRecyclerData()
    }

    private fun loadRecyclerData() {
        val itemsToday = repository.todayRecyclerData
        _todayDataset.value = itemsToday
        val itemsWeek = repository.weekRecyclerData
        _weekDataset.value = itemsWeek
    }

    override fun onCleared() {
        super.onCleared()
    }
}
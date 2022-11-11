package com.example.weatherapp.viewModel.homePage

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.homePage.recyclers.RecyclerviewsDatasource
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItemAdapter
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItemAdapter
import kotlinx.coroutines.flow.combine

class HomePageViewModel : ViewModel() {

    private val repository = Repository.getInstance()
    val currentTemperatureType = repository.currentTemperatureType.asLiveData()

    val temperature = combine(
        repository.temperatureToday,
        repository.currentTemperatureType
    ) { temperature, type ->
        "$temperature${type.toFormattedString()}"
    }.asLiveData()

    fun todayHourlyRecyclerview( view: View) {
        val todayDataset = RecyclerviewsDatasource().loadTodayViews()
        val todayRecyclerview = view.findViewById<RecyclerView>(R.id.temp_hourly_recyclerview)
        todayRecyclerview.adapter = TodayItemAdapter(todayDataset)
        todayRecyclerview.setHasFixedSize(true)
    }

    fun dailyWeekRecyclerview(view: View) {
        val weekDataset = RecyclerviewsDatasource().loadWeekViews()
        val weekRecyclerview = view.findViewById<RecyclerView>(R.id.temp_week_recyclerview)
        weekRecyclerview.adapter = WeekItemAdapter(weekDataset)
        weekRecyclerview.setHasFixedSize(true)
    }


}
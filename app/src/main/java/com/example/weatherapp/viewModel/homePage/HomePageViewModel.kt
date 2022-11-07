package com.example.weatherapp.viewModel.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.weatherapp.repository.Repository
import kotlinx.coroutines.flow.combine

class HomePageViewModel : ViewModel() {

    private val repository = Repository.getInstance()

    val temperature = combine(
        repository.temperatureToday,
        repository.currentTemperatureType
    ) { temperature, type ->
        "$temperature${type.toFormattedString()}"
    }.asLiveData()

}
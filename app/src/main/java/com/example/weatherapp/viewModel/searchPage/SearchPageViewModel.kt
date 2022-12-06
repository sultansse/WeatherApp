package com.example.weatherapp.viewModel.searchPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemCity

class SearchPageViewModel : ViewModel() {

    private val repository = Repository.getInstance()
    private var _cityDataset: MutableLiveData<List<ItemCity>> = MutableLiveData()
    val cityDataset: LiveData<List<ItemCity>> get() = _cityDataset


    init {
        loadRecyclerData()
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun onSearchDataChange(query: String?) {
        var temp: MutableList<ItemCity> = repository.allCities.toMutableList()
        if (query.toString() != "") {
            temp =
                temp.filter { city -> city.name.lowercase().contains(query.toString().lowercase()) }
                    .toMutableList()
        }
        _cityDataset.value = temp
    }

    private fun loadRecyclerData() {
        val itemsToday = repository.allCities
        _cityDataset.value = itemsToday
    }

}
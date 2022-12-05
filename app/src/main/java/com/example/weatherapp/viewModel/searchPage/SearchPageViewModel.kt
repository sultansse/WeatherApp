package com.example.weatherapp.viewModel.searchPage

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemCity

class SearchPageViewModel : ViewModel() {

    private val repository = Repository.getInstance()
    private var _cityDataset: MutableLiveData<List<ItemCity>> = MutableLiveData()
    val cityDataset: MutableLiveData<List<ItemCity>> get() = _cityDataset


    init {
        loadRecyclerData()
    }

    private fun loadRecyclerData() {
        val itemsToday = repository.allCities
        _cityDataset.value = itemsToday
    }

    override fun onCleared() {
        super.onCleared()
    }


    fun searchViewFilter(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//                adapter.filter.filter(newText)

                return false
            }
        })
    }

}
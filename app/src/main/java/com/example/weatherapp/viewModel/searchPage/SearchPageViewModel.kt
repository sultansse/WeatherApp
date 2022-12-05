package com.example.weatherapp.viewModel.searchPage

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItem
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItem
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemCity
import com.example.weatherapp.viewModel.searchPage.recyclers.SearchItemAdapter

class SearchPageViewModel : ViewModel() {

    private val repository = Repository.getInstance()
    private val allCities: MutableList<ItemCity> = repository.allCities.toMutableList()
    //here below is a problem
    private var _cityDataset: MutableLiveData<List<ItemCity>> = MutableLiveData()
    val cityDataset: MutableLiveData<List<ItemCity>> get() = _cityDataset


    init{
        loadRecyclerData()
    }


    override fun onCleared() {
        super.onCleared()
    }

    private fun loadRecyclerData() {
        val itemsToday = repository.allCities
        _cityDataset.value = itemsToday
    }

    fun searchViewFilter(view: View, searchView: SearchView) {
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
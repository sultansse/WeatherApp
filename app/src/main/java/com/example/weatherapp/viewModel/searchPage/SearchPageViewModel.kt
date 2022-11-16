package com.example.weatherapp.viewModel.searchPage

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemCity
import com.example.weatherapp.viewModel.searchPage.recyclers.SearchItemAdapter

class SearchPageViewModel : ViewModel() {

    val repository = Repository.getInstance()

    private val allCities: MutableList<ItemCity> = repository.allCities.toMutableList()

/*    TODO { Navigation }
    fun navToCity(view: View) {
        when(allCities[0].name){ // todo change as position of clicked recycle item
            "Astana" ->
                Navigation.findNavController(view).navigate(R.id.action_to_detailedCityFragment)
            "Aktobe" ->
                Navigation.findNavController(view).navigate(R.id.action_to_detailedCityFragment)

        }
    }*/

    fun loadRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewSearch)
        recyclerView.adapter = SearchItemAdapter(view, allCities);
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
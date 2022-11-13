package com.example.weatherapp.viewModel.searchPage.recyclers

class SearchFilter {
/*
    // filter ========================================================================

    lateinit var searchAdapter: SearchItemAdapter

    fun onSearchTextChange(view: View) {

        adapter?.getFilter()?.filter(newText);
        return true

    }

    fun onSearchTextSubmit(view: View) {
        adapter?.getFilter()?.filter(query)
        return true
    }

    searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
        override fun onQueryTextChange(newText: String?): Boolean {
            TODO("Not yet implemented")
            viewModel.onSearchTextChange(view)
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            TODO("Not yet implemented")
            viewModel.onSearchTextSubmit(view)
        }
    })


    private val cityFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<CityDataObject> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                initialCityDataList.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().toLowerCase()
                initialCityDataList.forEach {
                    if (it.cityName.toLowerCase(Locale.ROOT).contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                cityDataList.clear()
                cityDataList.addAll(results.values as ArrayList<CityDataObject>)
                notifyDataSetChanged()
            }
        }
    }
*/

}
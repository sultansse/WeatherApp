package com.example.weatherapp.viewModel.searchPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    val viewModel: SearchPageViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadRecyclerView(view)

        //listener to go detailed fragment todo
//        binding.root.recyclerItem.setOnClickListener(){
//          viewModel.navToCity(view)
//        }

/*        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        val filteredList = allCities.filter { it.name.contains(newText ?: "", ignoreCase = false) }
        itemsAdapter.submitList(filteredList)
        return true
    }

})
}

override fun onDestroyView() {
super.onDestroyView()
_binding = null
}

}
















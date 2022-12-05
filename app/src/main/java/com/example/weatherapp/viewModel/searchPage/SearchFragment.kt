package com.example.weatherapp.viewModel.searchPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.viewModel.searchPage.recyclers.SearchItemAdapter

class SearchFragment : Fragment() {

    val viewModel: SearchPageViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = binding.searchView
        viewModel.searchViewFilter(searchView)

        val recyclerView = binding.recyclerViewSearch
        recyclerView.adapter = SearchItemAdapter();
        recyclerView.setHasFixedSize(true)

        viewModel.cityDataset.observe(viewLifecycleOwner) {
            (recyclerView.adapter as SearchItemAdapter).submitList(it)
        }

        /*val itemsAdapter = ItemsAdapter(this);
        itemsAdapter.submitList(allCities)
        recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewSearch.setHasFixedSize(true)
        recyclerViewSearch.adapter = itemsAdapter


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
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

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG", itemsModal.name)
        when(itemsModal.name){
            "Astana" ->
                startActivity(Intent(requireContext(), City1Activity::class.java))
            "Aktobe" ->
                startActivity(Intent(requireContext(), City2Activity::class.java))
         else -> {
             Toast.makeText(requireContext(), "No Action",  Toast.LENGTH_LONG).show()
         }
        }
    }

*/
/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.bottom_nav_menu, menu)


    }
*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}






















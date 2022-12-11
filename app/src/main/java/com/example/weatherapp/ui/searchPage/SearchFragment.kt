package com.example.weatherapp.ui.searchPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.ui.searchPage.recyclers.SearchItemAdapter

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

        val adapter = SearchItemAdapter()
        binding.recyclerViewSearch.adapter = adapter;
        binding.recyclerViewSearch.setHasFixedSize(true)

        viewModel.cityDataset.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onSearchDataChange(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.onSearchDataChange(query)
                return false
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

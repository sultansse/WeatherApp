package com.example.weatherapp.viewModel.searchPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val searchView = binding.searchView
        viewModel.searchViewFilter(view, searchView)

        viewModel.loadRecyclerView(view)

/*        listener to go detailed fragment TODO { Navigation }
        binding.root.recyclerItem.setOnClickListener(){
          viewModel.navToCity(view)
        }*/


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}






















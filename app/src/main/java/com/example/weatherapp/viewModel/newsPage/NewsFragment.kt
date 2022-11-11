package com.example.weatherapp.viewModel.newsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    val viewModel: NewsPageViewModel by viewModels()
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadRecyclerview(view, "top") // preload recycler

        binding.tabLayout.getTabAt(0)?.view?.setOnClickListener() {
            viewModel.loadRecyclerview(view, "top")
        }
        binding.tabLayout.getTabAt(1)?.view?.setOnClickListener() {
            viewModel.loadRecyclerview(view, "daily")
        }
        binding.tabLayout.getTabAt(2)?.view?.setOnClickListener() {
            viewModel.loadRecyclerview(view, "other")
        }


    }

}
package com.example.weatherapp.viewModel.homePage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    val viewModel: HomePageViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.todayDateTextview.text =
            SimpleDateFormat("dd-LLLL").format(Calendar.getInstance().time).toString()

        viewModel.temperature.observe(viewLifecycleOwner) {
            binding.currentTempTextview.text = it
        }
//        binding.tempWeekRecyclerview.itemWeekDetails.setOnClickListener {
//            viewModel.navToWeekDetails(view)
//        }
        viewModel.todayHourlyRecyclerview(view)
        viewModel.dailyWeekRecyclerview(view)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

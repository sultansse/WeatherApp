package com.example.weatherapp.ui.homePage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.ui.homePage.recyclers.TodayItemAdapter
import com.example.weatherapp.ui.homePage.recyclers.WeekItemAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_week_details.view.*
import kotlinx.android.synthetic.main.item_week_details.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private val viewModel: HomePageViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
//    private lateinit var viewModel: HomePageViewModel
//    private var todayAdapter: TodayItemAdapter? = null
//    private var weekAdapter: WeekItemAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val application = requireNotNull(this.activity).application
//        val dataSource = TodayDatabase.getInstance(application).todayDatabaseDao
//        val viewModelFactory = HomePageViewModelFactory(dataSource, application)
//        viewModel =
//            ViewModelProvider(
//                this, viewModelFactory
//            )[HomePageViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todayAdapter = TodayItemAdapter()
        val weekAdapter = WeekItemAdapter()

        binding.todayDateTextview.text =
            SimpleDateFormat("dd-LLLL").format(Calendar.getInstance().time).toString()

        viewModel.temperature.observe(viewLifecycleOwner) {
            binding.currentTempTextview.text = it
        }

        val todayRecyclerview = binding.tempHourlyRecyclerview
        todayRecyclerview.adapter = todayAdapter
        todayRecyclerview.setHasFixedSize(true)
        viewModel.todayDataset.observe(viewLifecycleOwner) {
            todayAdapter.submitList(it)
        }

        // week daily recyclerview
        val weekRecyclerview = binding.tempWeekRecyclerview
        weekRecyclerview.adapter = weekAdapter
        weekRecyclerview.setHasFixedSize(true)
        viewModel.weekDataset.observe(viewLifecycleOwner) {
            weekAdapter.submitList(it)
        }

        viewModel.getweather(view)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

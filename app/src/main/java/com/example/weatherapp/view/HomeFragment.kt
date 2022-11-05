package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.viewModel.homePage.HomePageViewModel
import com.example.weatherapp.viewModel.homePage.recyclers.Datasource
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItemAdapter
import com.example.weatherapp.viewModel.homePage.recyclers.WeekItemAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.item_today_details.*
import kotlinx.android.synthetic.main.item_week_details.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todayDataset = Datasource().loadTodayViews()
        val todayRecyclerview = view.findViewById<RecyclerView>(R.id.todayDetailsRecycler)
        todayRecyclerview?.adapter = TodayItemAdapter(this, todayDataset)
        todayRecyclerview?.setHasFixedSize(true)

        val weekDataset = Datasource().loadWeekViews()
        val weekRecyclerview = view.findViewById<RecyclerView>(R.id.weekDaysDetailsRecycler)
        weekRecyclerview?.adapter = WeekItemAdapter(this, weekDataset)
        weekRecyclerview?.setHasFixedSize(true)


        var temperatureData = 28

        //todo if SettingsFragment.ToggleButton isClicked -> var temperatureFormat == ${R.string.temperature_format_f}" else ${R.string.temperature_format_c}"
        val temperature: String by lazy {
            "$temperatureData${resources.getString(R.string.temperature_format_c)}"
        }
        today_temperature.text = temperature

        today_temperature.setOnClickListener {
            temperatureData++
            today_temperature.text = temperature
        }


        // view model instance
        var viewModel: HomePageViewModel = ViewModelProvider(this)[HomePageViewModel::class.java]

        // homePage's variables \ texts
        /*       today_temperature.text = viewModel.toString()
               humidity.text = viewModel.toString()
               today_descriptionOfTemp.text = viewModel.toString()
               windiness.text = viewModel.toString()
               pressure.text = viewModel.toString()
               // first recyclerview / Today temperature per hour
               tempOfTime.text = viewModel.toString()
               timeForToday.text = viewModel.toString()
               //  second recyclerview / week temperature per day
               dayOfWeek.text = viewModel.toString()
               dayTempOfDayWeek.text = viewModel.toString()
               nightTempOfDayWeek.text = viewModel.toString()*/

    }

}





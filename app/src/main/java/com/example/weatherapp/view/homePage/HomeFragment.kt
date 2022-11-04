package com.example.weatherapp.view.homePage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.view.homePage.recyclers.Datasource
import com.example.weatherapp.view.homePage.recyclers.TodayItemAdapter
import com.example.weatherapp.view.homePage.recyclers.WeekItemAdapter
import com.example.weatherapp.viewModel.homePage.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.item_today_details.*
import kotlinx.android.synthetic.main.item_week_details.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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

        val temperature = 28
        view.findViewById<TextView>(R.id.today_temperature)?.text = "$temperature°C"

        // view model instance
        var viewModel: HomePageViewModel = ViewModelProvider(this)[HomePageViewModel::class.java]
        // homePage's variables \ texts

//        today_temperature.text = viewModel.toString()
//        humidity.text = viewModel.toString()
//        today_descriptionOfTemp.text = viewModel.toString()
//        windiness.text = viewModel.toString()
//        pressure.text = viewModel.toString()
//        // first recyclerview / Today temperature per hour
//        tempOfTime.text = viewModel.toString()
//        timeForToday.text = viewModel.toString()
//        //  second recyclerview / week temperature per day
//        dayOfWeek.text = viewModel.toString()
//        dayTempOfDayWeek.text = viewModel.toString()
//        nightTempOfDayWeek.text = viewModel.toString()

    }

}





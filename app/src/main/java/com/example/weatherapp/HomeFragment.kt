package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.homePageElements.recyclers.Datasource
import com.example.weatherapp.homePageElements.recyclers.TodayItemAdapter
import com.example.weatherapp.homePageElements.recyclers.WeekItemAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        problem doubled code, doubled class TODO
        val todayDataset = Datasource().loadTodayViews()
        val todayRecyclerview = getView()?.findViewById<RecyclerView>(R.id.todayDetailsRecycler)
        todayRecyclerview?.adapter = TodayItemAdapter(this, todayDataset)
        todayRecyclerview?.setHasFixedSize(true)

        val weekDataset = Datasource().loadWeekViews()
        val weekRecyclerview = getView()?.findViewById<RecyclerView>(R.id.weekDaysDetailsRecycler)
        weekRecyclerview?.adapter = WeekItemAdapter(this, weekDataset)
        weekRecyclerview?.setHasFixedSize(true)

    }

}
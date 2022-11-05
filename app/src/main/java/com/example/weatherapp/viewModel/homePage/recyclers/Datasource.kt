package com.example.weatherapp.viewModel.homePage.recyclers;

import com.example.weatherapp.repository.Repository

class Datasource {

    fun loadTodayViews(): MutableList<TodayItem> {
        val res = mutableListOf<TodayItem>()
        res.addAll(
           Repository().todayRecyclerData
        )
        return res
    }

    fun loadWeekViews(): MutableList<WeekItem> {
        val res = mutableListOf<WeekItem>()
        res.addAll(
           Repository().weekRecyclerData
        )
        return res
    }

}
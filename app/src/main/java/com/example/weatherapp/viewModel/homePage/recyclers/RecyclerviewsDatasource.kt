package com.example.weatherapp.viewModel.homePage.recyclers;

import com.example.weatherapp.repository.Repository

class RecyclerviewsDatasource {

    fun loadTodayViews(): MutableList<TodayItem> {
        val res = mutableListOf<TodayItem>()
        res.addAll(
            Repository.getInstance().todayRecyclerData
        )
        return res
    }

    fun loadWeekViews(): MutableList<WeekItem> {
        val res = mutableListOf<WeekItem>()
        res.addAll(
            Repository.getInstance().weekRecyclerData
        )
        return res
    }

}
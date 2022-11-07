package com.example.weatherapp.viewModel.NewsPage.recycler

import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.homePage.recyclers.TodayItem


class DatasourceNews {

        fun loadNewsViews(): MutableList<RecyclerItem> {
            val res = mutableListOf<RecyclerItem>()
            res.addAll(
                Repository.getInstance().newsRecyclerData
            )
            return res
        }
//
//        fun loadWeekViews(): MutableList<WeekItem> {
//            val res = mutableListOf<WeekItem>()
//            res.addAll(
//                Repository.getInstance().weekRecyclerData
//            )
//            return res
//        }


}
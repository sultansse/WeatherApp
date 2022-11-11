package com.example.weatherapp.viewModel.newsPage.recycler

import com.example.weatherapp.repository.Repository


class DatasourceNews {

    fun loadTopNews(): MutableList<RecyclerItem> {
        val res = mutableListOf<RecyclerItem>()
        res.addAll(
            Repository.getInstance().topNewsRecyclerData
        )
        return res
    }

    fun loadDailyNews(): MutableList<RecyclerItem> {
        val res = mutableListOf<RecyclerItem>()
        res.addAll(
            Repository.getInstance().dailyNewsRecyclerData
        )
        return res
    }

    fun loadOtherNews(): MutableList<RecyclerItem> {
        val res = mutableListOf<RecyclerItem>()
        res.addAll(
            Repository.getInstance().otherNewsRecyclerData
        )
        return res
    }

}
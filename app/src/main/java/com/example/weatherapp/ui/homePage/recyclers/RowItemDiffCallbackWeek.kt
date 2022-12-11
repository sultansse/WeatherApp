package com.example.weatherapp.ui.homePage.recyclers

import androidx.recyclerview.widget.DiffUtil

class RowItemDiffCallbackWeek : DiffUtil.ItemCallback<WeekItem>() {

    override fun areItemsTheSame(oldItem: WeekItem, newItem: WeekItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeekItem, newItem: WeekItem): Boolean {
        return oldItem == newItem
    }
}


class RowItemDiffCallbackToday : DiffUtil.ItemCallback<TodayItem>() {
    override fun areItemsTheSame(oldItem: TodayItem, newItem: TodayItem): Boolean {
        //need check id for each element in data class
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TodayItem, newItem: TodayItem): Boolean {
        return oldItem == newItem
    }
}

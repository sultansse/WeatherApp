package com.example.weatherapp.viewModel.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R


class TodayItemAdapter(
    private val todayDataset: MutableList<TodayItem>
) : RecyclerView.Adapter<TodayItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val temperaturePerHour: TextView = view.findViewById(R.id.time_of_today_textview)
        val eachTimeToday: TextView = view.findViewById(R.id.time_of_today_textview)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_today_details, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = todayDataset[position]
        val context = holder.temperaturePerHour.context
        holder.temperaturePerHour.text = context.getString(item.tempOfTime)
        holder.eachTimeToday.text = context.getString(item.timeForToday)
    }


    override fun getItemCount() = todayDataset.size
}

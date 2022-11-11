package com.example.weatherapp.viewModel.homePage.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R


class WeekItemAdapter(
    private val weekDataset: MutableList<WeekItem>
) : RecyclerView.Adapter<WeekItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayOfWeek: TextView = view.findViewById(R.id.day_of_week_textview)

        //        val weatherIconPerHour: ImageView = view.findViewById(R.id.weatherIconPerHour)
        val dayTempOfDayWeek: TextView = view.findViewById(R.id.daytime_temperature_week_textview)
        val nightTempOfDayWeek: TextView =
            view.findViewById(R.id.nighttime_temperature_week_textview)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_week_details, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = weekDataset[position]
        val context = holder.dayOfWeek.context

        holder.dayOfWeek.text = context.resources.getString(item.dayOfWeek)
//        holder.weatherIconPerHour.setImageResource(item.weatherIconPerHour)
        holder.dayTempOfDayWeek.text = context.resources.getString(item.dayTempOfDayWeek)
        holder.nightTempOfDayWeek.text = context.resources.getString(item.nightTempOfDayWeek)
    }


    override fun getItemCount() = weekDataset.size
}
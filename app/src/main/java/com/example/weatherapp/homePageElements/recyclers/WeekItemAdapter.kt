package com.example.weatherapp.homePageElements.recyclers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.HomeFragment
import com.example.weatherapp.R


class WeekItemAdapter(
    private val context: HomeFragment,
    private val weekDataset: MutableList<WeekItem>
) : RecyclerView.Adapter<WeekItemAdapter.ItemViewHolder>() {



    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val dayOfWeek: TextView = view.findViewById(R.id.dayOfWeek)
//        val weatherIconPerHour: ImageView = view.findViewById(R.id.weatherIconPerHour)
        val dayTempOfDayWeek: TextView = view.findViewById(R.id.dayTempOfDayWeek)
        val nightTempOfDayWeek: TextView = view.findViewById(R.id.nightTempOfDayWeek)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_week_details, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = weekDataset[position]

        holder.dayOfWeek.text = context.resources.getString(item.dayOfWeek)
//        holder.weatherIconPerHour.setImageResource(item.weatherIconPerHour)
        holder.dayTempOfDayWeek.text = context.resources.getString(item.dayTempOfDayWeek)
        holder.nightTempOfDayWeek.text = context.resources.getString(item.nightTempOfDayWeek)
    }


    override fun getItemCount() = weekDataset.size
}
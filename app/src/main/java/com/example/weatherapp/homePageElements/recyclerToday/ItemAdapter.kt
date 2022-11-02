package com.example.weatherapp.homePageElements.recyclerToday


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.HomeFragment
import com.example.weatherapp.R


class ItemAdapter(
    private val context: HomeFragment,
    private val dataset: MutableList<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val temperaturePerHour: TextView = view.findViewById(R.id.tempOfTime)
//        val weatherIconPerHour: ImageView = view.findViewById(R.id.weatherIconPerHour)
        val eachTimeToday: TextView = view.findViewById(R.id.timeForToday)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_today_details, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.temperaturePerHour.text = context.resources.getString(item.tempOfTime)
//        holder.weatherIconPerHour.setImageResource(item.weatherIconPerHour)
        holder.eachTimeToday.text = context.resources.getString(item.timeForToday)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
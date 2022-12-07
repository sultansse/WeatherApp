package com.example.weatherapp.viewModel.searchPage.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.search_items.view.*

class SearchItemAdapter :
    ListAdapter<ItemCity, SearchItemAdapter.ItemViewHolder>(RowItemDiffCallbackCity()) {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.RecycleItemImage)
        val name: TextView = view.findViewById(R.id.RecycleItemName)
        val desc: TextView = view.findViewById(R.id.RecycleItemDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.search_items, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.desc.text = item.desc
        holder.img.setImageResource(item.image)

        holder.itemView.constraint.setOnClickListener() {
            Navigation.findNavController(holder.itemView)
                .navigate(R.id.action_to_detailedCityFragment)
        }
    }

}


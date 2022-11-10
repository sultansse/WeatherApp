package com.example.weatherapp.viewModel.searchPage.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.searchPage.recyclers.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.search_items.view.*

class ItemsAdapter(var clickListener: ClickListener) : ListAdapter<ItemsModal, ItemsAdapterVH>(
    diffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(
            LayoutInflater.from(parent.context).inflate(R.layout.search_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = getItem(position)
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener {
            clickListener.ClickedItem(itemsModal)
        }
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.cityName
        val desc = itemView.cityInfo
        val image = itemView.SearchImageView
    }

    interface ClickListener {
        fun ClickedItem(itemsModal: ItemsModal)
    }
}

private val diffUtil = object : DiffUtil.ItemCallback<ItemsModal>() {
    override fun areItemsTheSame(oldItem: ItemsModal, newItem: ItemsModal): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ItemsModal, newItem: ItemsModal): Boolean {
        return oldItem == newItem
    }
}
package com.example.weatherapp.viewModel.searchPage.recyclers

import androidx.recyclerview.widget.DiffUtil

class RowItemDiffCallbackCity : DiffUtil.ItemCallback<ItemCity>() {

        override fun areItemsTheSame(oldItem: ItemCity, newItem: ItemCity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemCity, newItem: ItemCity): Boolean {
            return oldItem == newItem
        }
    }
package com.example.mvvm_coroutines_retrofit.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_coroutines_retrofit.databinding.RestaurantItemBinding
import com.example.mvvm_coroutines_retrofit.models.Restaurants

class RestaurantViewHolder(
    private val binding: RestaurantItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(restaurants: Restaurants) {
        binding.restaurantDetails = restaurants
    }
}
package com.example.mvvm_coroutines_retrofit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_coroutines_retrofit.databinding.RestaurantItemBinding
import com.example.mvvm_coroutines_retrofit.models.Restaurants

class RestaurantAdapter(
    private val restaurantsList: List<Restaurants>
): RecyclerView.Adapter<RestaurantViewHolder>()  {

    private lateinit var binding: RestaurantItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int = restaurantsList.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantsList[position]
        holder.bind(restaurant)
    }

}


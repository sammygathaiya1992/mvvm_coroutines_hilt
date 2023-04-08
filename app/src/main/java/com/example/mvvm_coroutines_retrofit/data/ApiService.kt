package com.example.mvvm_coroutines_retrofit.data

import com.example.mvvm_coroutines_retrofit.models.Restaurants
import retrofit2.http.GET

interface ApiService {

    @GET("restaurants.json")
    suspend fun getAllRestaurants(): List<Restaurants>

}
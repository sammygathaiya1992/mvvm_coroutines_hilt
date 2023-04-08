package com.example.mvvm_coroutines_retrofit.data.repository

import com.example.mvvm_coroutines_retrofit.data.ApiService
import com.example.mvvm_coroutines_retrofit.data.RetrofitUtil
import com.example.mvvm_coroutines_retrofit.models.Restaurants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RestaurantsRepository(
    private val defaultDispatcher: CoroutineDispatcher
) {

    private var apiService = RetrofitUtil.getInstance().create(ApiService::class.java)

    suspend fun getAllRestaurants(): List<Restaurants> {
        return withContext(defaultDispatcher) {
            apiService.getAllRestaurants()
        }

    }
}
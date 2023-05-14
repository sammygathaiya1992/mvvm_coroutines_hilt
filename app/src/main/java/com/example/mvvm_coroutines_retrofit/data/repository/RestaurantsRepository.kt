package com.example.mvvm_coroutines_retrofit.data.repository

import com.example.mvvm_coroutines_retrofit.data.ApiService
import com.example.mvvm_coroutines_retrofit.di.IoDispatcher
import com.example.mvvm_coroutines_retrofit.models.Restaurants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantsRepository @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getAllRestaurants(): List<Restaurants> {
        return withContext(ioDispatcher) {
            apiService.getAllRestaurants()
        }

    }
}
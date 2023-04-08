package com.example.mvvm_coroutines_retrofit.models


data class RestaurantsUiState(
    val restaurants: List<Restaurants>,
    val error: Any,
    val hasError: Boolean
)

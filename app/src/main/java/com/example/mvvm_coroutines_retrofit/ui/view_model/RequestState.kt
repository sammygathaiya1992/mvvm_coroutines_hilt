package com.example.mvvm_coroutines_retrofit.ui.view_model

import com.example.mvvm_coroutines_retrofit.models.Restaurants


sealed class RequestState {
    object Loading : RequestState()
    data class Success(val restaurants: List<Restaurants>) : RequestState()
    data class Error(val message: String) : RequestState()
}
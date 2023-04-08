package com.example.mvvm_coroutines_retrofit.models

import com.google.gson.annotations.SerializedName

data class Restaurants(
    @SerializedName("r_id")
    val id: String,

    @SerializedName("r_title")
    val title: String,

    @SerializedName("r_description")
    val description: String
)

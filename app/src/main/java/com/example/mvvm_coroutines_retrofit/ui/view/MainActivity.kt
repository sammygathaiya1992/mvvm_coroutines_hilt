package com.example.mvvm_coroutines_retrofit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_coroutines_retrofit.databinding.ActivityMainBinding
import com.example.mvvm_coroutines_retrofit.models.Restaurants
import com.example.mvvm_coroutines_retrofit.ui.adapters.RestaurantAdapter
import com.example.mvvm_coroutines_retrofit.ui.view_model.RequestState
import com.example.mvvm_coroutines_retrofit.ui.view_model.RestaurantsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val restaurantsViewModel: RestaurantsViewModel by viewModels()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        restaurantsViewModel.state().observe(this) { state ->
            if (state != null){
                getRestaurantsResponse(state)
            }
        }

        //get all restaurants
        restaurantsViewModel.getAllRestaurants()

    }

    private fun getRestaurantsResponse(state: RequestState){
        when(state){
            is RequestState.Loading -> {
             onLoading()
            }
            is RequestState.Error -> {
                onError(state)
            }
            is RequestState.Success -> {
                onSuccess(state)
            }
        }
    }

    private fun setUpAdapter(list: List<Restaurants>){
        binding.rvRestaurants.layoutManager = LinearLayoutManager(this)
        binding.rvRestaurants.adapter = RestaurantAdapter(list)
    }

    private fun onLoading(){
        binding.progressBar.visibility= View.VISIBLE
    }

    private fun onSuccess(requestState: RequestState.Success) = with(binding){
        binding.progressBar.visibility= View.GONE
        if (requestState.restaurants.isNotEmpty()){
            setUpAdapter(requestState.restaurants)
        }else{
            Toast.makeText(this@MainActivity, "No list found", Toast.LENGTH_LONG).show()
        }
    }

    private fun onError(requestState: RequestState.Error) = with(binding){
        binding.progressBar.visibility= View.GONE
        Toast.makeText(this@MainActivity, requestState.message, Toast.LENGTH_LONG).show()

    }

}
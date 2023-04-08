package com.example.mvvm_coroutines_retrofit.ui.view_model


import androidx.lifecycle.viewModelScope
import com.example.mvvm_coroutines_retrofit.data.repository.RestaurantsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantsViewModel(
    dispatcher: CoroutineDispatcher = Dispatchers.IO
): BaseViewModel<RequestState>() {

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        requestState.value = exception.message?.let { RequestState.Error(it) }
        }

    private val restaurantsRepository = RestaurantsRepository(dispatcher)

    fun getAllRestaurants(){
        requestState.value = RequestState.Loading
        viewModelScope.launch(errorHandler) {
            val restaurantsLists = restaurantsRepository.getAllRestaurants()
            requestState.value = RequestState.Success(restaurantsLists)
        }
    }

}
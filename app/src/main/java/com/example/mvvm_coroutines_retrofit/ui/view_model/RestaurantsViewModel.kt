package com.example.mvvm_coroutines_retrofit.ui.view_model


import androidx.lifecycle.viewModelScope
import com.example.mvvm_coroutines_retrofit.data.repository.RestaurantsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantsRepository
): BaseViewModel<RequestState>() {

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        requestState.value = exception.message?.let { RequestState.Error(it) }
        }

    fun getAllRestaurants(){
        requestState.value = RequestState.Loading
        viewModelScope.launch(errorHandler) {
            val restaurantsLists = restaurantsRepository.getAllRestaurants()
            requestState.value = RequestState.Success(restaurantsLists)
        }
    }

}
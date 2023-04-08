package com.example.mvvm_coroutines_retrofit.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {

    fun state(): LiveData<T> = requestState
    protected val requestState: MutableLiveData<T> = MutableLiveData()
}
package com.example.lab7ez.mealdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7ez.mealdetail.repository.mealsdetailrepo
import com.example.lab7ez.navigation.response.DetailResponse

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class mealdetailviewmodel(private val repository: mealsdetailrepo = mealsdetailrepo()) : ViewModel() {

    private val _mealDetail = MutableStateFlow<DetailResponse?>(null)
    val mealDetail: StateFlow<DetailResponse?> get() = _mealDetail

    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = repository.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}
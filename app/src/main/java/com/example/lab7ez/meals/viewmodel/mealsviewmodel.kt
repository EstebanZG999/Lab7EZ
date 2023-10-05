package com.example.lab7ez.meals.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab7ez.meals.repository.mealsrepo
import com.example.lab7ez.navigation.response.mealCategoryResponse

class mealsviewmodel (private val repository: mealsrepo = mealsrepo()): ViewModel() {
    fun getMeals(successCallback: (response: mealCategoryResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}
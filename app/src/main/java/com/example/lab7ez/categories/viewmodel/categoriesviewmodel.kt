package com.example.lab7ez.categories.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab7ez.categories.repository.categoriesrepo
import com.example.lab7ez.navigation.response.CategoriesResponse


class categoriesviewmodel(private val repository: categoriesrepo = categoriesrepo()): ViewModel() {
    fun getCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getCategories(categoryId) { response ->
            successCallback(response)
        }
    }
}
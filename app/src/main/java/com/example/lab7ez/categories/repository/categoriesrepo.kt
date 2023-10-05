package com.example.lab7ez.categories.repository

import com.example.lab7ez.MealsWebService
import com.example.lab7ez.navigation.response.CategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class categoriesrepo(private val web: MealsWebService = MealsWebService()) {

    fun getCategories(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        println("Repository getMealsInCategory Invoked with categoryId: $categoryId")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = web.getCategories(categoryId)
                withContext(Dispatchers.Main) {
                    println("API Call successful. Response: ${response}")

                    if (response != null) {
                        successCallback(response)
                    }
                }
            } catch (e: HttpException) {
                withContext(Dispatchers.Main) {
                    println("API Call failed. Error: ${e.response()?.errorBody()}")
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    println("API Call failed. Error: $e")
                }
            }
        }
    }
}
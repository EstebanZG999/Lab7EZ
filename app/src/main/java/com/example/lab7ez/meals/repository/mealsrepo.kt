package com.example.lab7ez.meals.repository

import com.example.lab7ez.MealsWebService
import com.example.lab7ez.navigation.response.mealCategoryResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class mealsrepo(private val web: MealsWebService = MealsWebService()) {

    fun getMeals(successCallback: (response: mealCategoryResponse?) -> Unit) {
        println("Repository getMeals Invoked")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = web.getMeals()
                withContext(Dispatchers.Main) {
                    println("API Call successful. Response: ${response}")
                    successCallback(response)
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



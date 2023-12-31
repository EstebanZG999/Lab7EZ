package com.example.lab7ez.mealdetail.repository

import com.example.lab7ez.MealsWebService
import com.example.lab7ez.navigation.response.DetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class mealsdetailrepo(private val web: MealsWebService = MealsWebService()) {

    suspend fun getMealDetail(mealId: String): DetailResponse? {
        println("Attempting to fetch meal detail with mealId: $mealId") // Imprime el mealId
        println("URL: https://www.themealdb.com/api/json/v1/1/lookup.php?i=$mealId") // Imprime la URL completa

        return withContext(Dispatchers.IO) {
            try {
                val response = web.getDetail(mealId)
                println("Response: $response") // Imprime la respuesta completa
                response
            } catch (e: Exception) {
                println("Error: ${e.localizedMessage}") // Imprime cualquier error que ocurra
                null
            }
        }
    }

}
package com.example.lab7ez

import com.example.lab7ez.navigation.response.CategoriesResponse
import com.example.lab7ez.navigation.response.DetailResponse
import com.example.lab7ez.navigation.response.mealCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): mealCategoryResponse

    @GET("filter.php")
    suspend fun getMealsInCategory(@Query("c") categoryId: String): CategoriesResponse

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): DetailResponse?
}

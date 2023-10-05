package com.example.lab7ez

import com.example.lab7ez.navigation.response.CategoriesResponse
import com.example.lab7ez.navigation.response.DetailResponse
import com.example.lab7ez.navigation.response.mealCategoryResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {
    private lateinit var api: MealsApi

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMeals(): mealCategoryResponse {
        return api.getMeals()
    }

    suspend fun getCategories(categoryId: String): CategoriesResponse {
        val url = "$categoryId"
        println("WebService getMealsInCategory Invoked with URL: $url")
        return api.getMealsInCategory("$categoryId")
    }

    suspend fun getDetail(mealId: String): DetailResponse? {
        return api.getMealDetail(mealId)
    }


}
package com.example.lab7ez.navigation.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>?
)

data class MealDetail(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strInstructions") val strInstructions: String
)
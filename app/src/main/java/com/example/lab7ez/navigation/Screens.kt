package com.example.lab7ez.navigation

sealed class Screens(val route: String) {
    object inicio: Screens("inicio")
    object category: Screens("category/{categoryId}")
    object detail: Screens("detail/{mealId}")

}
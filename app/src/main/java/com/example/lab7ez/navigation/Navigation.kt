package com.example.lab7ez.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7ez.meals.view.mealsscreen
import com.example.lab7ez.categories.view.categoriesscreen
import com.example.lab7ez.mealdetail.view.mealdetailscreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.inicio.route,
        modifier = modifier) {
        composable(route = Screens.inicio.route) {
            mealsscreen(navController)
        }
        composable(route = Screens.category.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                // Navigate to the appropriate screen
                categoriesscreen(categoryId, navController)
            }
        }
        composable(route = "${Screens.detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                mealdetailscreen(mealId)
            }
        }
    }
}
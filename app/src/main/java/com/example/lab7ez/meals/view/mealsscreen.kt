package com.example.lab7ez.meals.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lab7ez.meals.viewmodel.mealsviewmodel
import com.example.lab7ez.navigation.response.MealResponse

@Composable
fun mealsscreen(navController: NavController) {
    val viewModel: mealsviewmodel = viewModel()
    val rememberedMeals by produceState(initialValue = emptyList<MealResponse>(), producer = {
        value = emptyList()
        viewModel.getMeals { response ->
            value = response?.categories.orEmpty()
        }
    })

    DisplayMeals(rememberedMeals, navController)
}

@Composable
fun DisplayMeals(meals: List<MealResponse>, navController: NavController) {
    LazyColumn {
        items(meals) { meal ->
            MealItem(meal, navController)
        }
    }
}

@Composable
fun MealItem(meal: MealResponse, navController: NavController) {
    ClickableText(
        text = AnnotatedString(text = meal.name),
        onClick = {
            navController.navigate("Category/${meal.name}")
        }
    )
}

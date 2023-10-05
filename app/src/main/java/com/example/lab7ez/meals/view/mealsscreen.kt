package com.example.lab7ez.meals.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lab7ez.meals.viewmodel.mealsviewmodel
import com.example.lab7ez.navigation.response.MealResponse


@Composable
fun mealsscreen(navController: NavController) {
    val viewModel: mealsviewmodel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            ClickableText(
                text = AnnotatedString(text = meal.name),
                onClick = { offset ->
                    navController.navigate("Category/${meal.name}")
                }
            )
        }
    }

}
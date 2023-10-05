package com.example.lab7ez.mealdetail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab7ez.mealdetail.viewmodel.mealdetailviewmodel


@Composable
fun mealdetailscreen(mealId: String) {

    val viewModel: mealdetailviewmodel = viewModel()

    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val mealDetail by viewModel.mealDetail.collectAsState(null)

    val currentMealId by rememberUpdatedState(mealId)


    Column {
        if (mealDetail != null) {
            Text(text = mealDetail!!.meals?.first()?.strMeal ?: "Cargando...")
            Text(text = mealDetail!!.meals?.first()?.strInstructions ?: "No instructions available")
        } else {
            Text("Cargando detalles de la comida...")
        }
    }
}
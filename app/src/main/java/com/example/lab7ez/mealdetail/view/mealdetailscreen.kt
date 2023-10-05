package com.example.lab7ez.mealdetail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab7ez.mealdetail.viewmodel.mealdetailviewmodel
import com.example.lab7ez.navigation.response.DetailResponse

@Composable
fun mealdetailscreen(mealId: String) {
    val viewModel: mealdetailviewmodel = viewModel()

    // Fetch meal details when mealId changes
    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    val mealDetail by viewModel.mealDetail.collectAsState(null)

    DisplayMealDetails(mealDetail)
}

@Composable
fun DisplayMealDetails(mealDetail: DetailResponse?) {
    LazyColumn {
        item {
            if (mealDetail != null) {
                MealInfo(mealDetail)
            } else {
                LoadingIndicator()
            }
        }
    }
}

@Composable
fun MealInfo(mealDetail: DetailResponse) {
    Text(text = mealDetail.meals?.first()?.strMeal ?: "Cargando...")
    Text(text = mealDetail.meals?.first()?.strInstructions ?: "No instructions available")
}

@Composable
fun LoadingIndicator() {
    Text("Cargando detalles de la comida...")
}

package com.example.lab7ez.categories.view

import com.example.lab7ez.navigation.Screens
import com.example.lab7ez.navigation.response.CategoryResponse
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lab7ez.categories.viewmodel.categoriesviewmodel

@Composable
fun categoriesscreen(categoryId: String, navController: NavController) {
    val viewModel: categoriesviewmodel = viewModel()
    val rememberedMeals = produceState(initialValue = emptyList<CategoryResponse>(), producer = {
        value = emptyList()
        viewModel.getCategory(categoryId) { response ->
            value = response?.categories.orEmpty()
        }
    })

    DisplayCategories(rememberedMeals.value, navController)
}

@Composable
fun DisplayCategories(categories: List<CategoryResponse>, navController: NavController) {
    LazyColumn {
        items(categories) { category ->
            CategoryItem(category, navController)
        }
    }
}

@Composable
fun CategoryItem(category: CategoryResponse, navController: NavController) {
    ClickableText(
        text = AnnotatedString(text = category.name),
        onClick = {
            navController.navigate("${Screens.detail.route}/${category.idmeal}")
        }
    )
}



package com.example.newsapi.presentation.details_news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapi.presentation.details_news.components.NewsDetailsItem

@ExperimentalMaterialApi
@Composable
fun FinalSpaceDetailsScreen(
    navController: NavController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.newsDetails?.let {
            NewsDetailsItem(it,navController)
        }
    }
}
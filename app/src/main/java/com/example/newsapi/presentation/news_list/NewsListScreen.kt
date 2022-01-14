package com.example.newsapi.presentation.news_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapi.navigation.screen.Screen
import com.example.newsapi.presentation.news_list.components.SingleNewsList
import com.example.newsapi.ui.spacing

@Composable
fun NewsDetailsScreen(
    navController: NavController,
    viewModel: NewsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .background(Color.LightGray)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
        ) {
            items(state.newsData) { coin ->
                SingleNewsList(
                    finalSpaceItemDto = coin
                ) {
                    navController.navigate(Screen.NewsDetailsScreen.route + "/${coin.id}")
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.large)
                    .align(Alignment.BottomCenter)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
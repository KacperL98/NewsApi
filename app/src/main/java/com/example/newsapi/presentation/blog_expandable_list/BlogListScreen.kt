package com.example.newsapi.presentation.blog_expandable_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapi.presentation.blog_expandable_list.components.ExpandableList

@Composable
fun NetworkScreen(
    navController: NavController,
    viewModel: BlogsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val expandedCardIds = viewModel.expandedCardIdsList.collectAsState()
    Box(
        modifier = Modifier
            .background(Color.LightGray)
    ) {
        LazyColumn {
            itemsIndexed(state.newsData) { _, card ->
                ExpandableList(
                    card = card,
                    onCardArrowClick = { viewModel.onCardArrowClicked(card.id) },
                    expanded = expandedCardIds.value.contains(card.id),
                )
            }
        }
    }
}
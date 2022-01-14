package com.example.newsapi.presentation.details_news.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.newsapi.R
import com.example.newsapi.navigation.screen.BottomNavItem
import com.example.newsapi.ui.spacing
import com.example.newsapi.ui.theme.Blue


@Composable
fun TopAppBarNews(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.back), style = MaterialTheme.typography.h6, color = Color.White)
        },
        navigationIcon = {
            IconButton(onClick = {navController.navigate(BottomNavItem.NewsList.screen_route)}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = Blue,
        contentColor = Color.White,
        elevation = MaterialTheme.spacing.small
    )
}
package com.example.newsapi.navigation.screen

sealed class Screen(val route: String) {
    object NewsDetailsScreen : Screen("news_details_screen")
}
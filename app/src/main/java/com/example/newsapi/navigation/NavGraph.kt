package com.example.newsapi.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapi.navigation.screen.BottomNavItem
import com.example.newsapi.navigation.screen.Screen
import com.example.newsapi.presentation.blog_expandable_list.BlogsListViewModel
import com.example.newsapi.presentation.blog_expandable_list.NetworkScreen
import com.example.newsapi.presentation.details_news.FinalSpaceDetailsScreen
import com.example.newsapi.presentation.news_list.NewsDetailsScreen
import com.example.newsapi.presentation.news_list.NewsListViewModel

@ExperimentalMaterialApi
@Composable
fun NavigationGraph(navController: NavHostController, newsListViewModel: NewsListViewModel, blogsListViewModel: BlogsListViewModel) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            NewsDetailsScreen(navController)
        }
        composable(
            route = Screen.NewsDetailsScreen.route + "/{id}"
        ) {
            FinalSpaceDetailsScreen(navController)
        }
        composable(BottomNavItem.MyNetwork.screen_route) {
            NetworkScreen(navController, blogsListViewModel)
        }
    }
}
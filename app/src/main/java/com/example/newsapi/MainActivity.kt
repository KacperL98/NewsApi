package com.example.newsapi

import com.example.newsapi.ui.theme.NewsApiTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.newsapi.navigation.BottomNavigation
import com.example.newsapi.navigation.NavigationGraph
import com.example.newsapi.presentation.blog_expandable_list.BlogsListViewModel
import com.example.newsapi.presentation.news_list.NewsListViewModel
import com.example.newsapi.ui.spacing
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    private val newsListViewModel: NewsListViewModel by viewModels()
    private val blogsListViewModel: BlogsListViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApiTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigation(navController = navController) }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(
                            PaddingValues(
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                                MaterialTheme.spacing.default,
                                innerPadding.calculateBottomPadding()
                            )
                        )
                    ) {
                        NavigationGraph(
                            navController = navController,
                            newsListViewModel,
                            blogsListViewModel
                        )
                    }
                }
            }
        }
    }
}
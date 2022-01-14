package com.example.newsapi.navigation.screen

import com.example.newsapi.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("News", R.drawable.news_icon, "news")
    object MyNetwork : BottomNavItem("Blog", R.drawable.blog_icon, "blog")
}

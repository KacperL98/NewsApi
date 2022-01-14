package com.example.newsapi.presentation.news_list

import com.example.newsapi.data.remote.dto.NewsListDto

data class NewsListState(
    val isLoading: Boolean = false,
    val newsData: List<NewsListDto> = emptyList(),
    val error: String = ""
)
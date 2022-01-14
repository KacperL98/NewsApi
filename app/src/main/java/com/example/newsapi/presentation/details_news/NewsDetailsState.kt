package com.example.newsapi.presentation.details_news

import com.example.newsapi.data.remote.dto.NewsDetailsDto

data class NewsDetailsState(
    val isLoading: Boolean = false,
    val newsDetails: NewsDetailsDto? = null,
    val error: String = ""
)
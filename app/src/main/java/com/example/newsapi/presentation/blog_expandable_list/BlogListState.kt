package com.example.newsapi.presentation.blog_expandable_list

import com.example.newsapi.data.remote.dto.BlogsListDto

data class BlogListState(
    val isLoading: Boolean = false,
    val newsData: List<BlogsListDto> = emptyList(),
    val error: String = ""
)
package com.example.newsapi.domain.repository

import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.data.remote.dto.NewsDetailsDto
import com.example.newsapi.data.remote.dto.NewsListDto

interface NewsRepository {

    suspend fun getNewsList(): List<NewsListDto>

    suspend fun getNewsDetails(id: Int): NewsDetailsDto

    suspend fun getBlogsList(): List<BlogsListDto>

}
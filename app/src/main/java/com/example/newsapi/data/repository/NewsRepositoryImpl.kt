package com.example.newsapi.data.repository

import com.example.newsapi.data.remote.NewsApi
import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.data.remote.dto.NewsDetailsDto
import com.example.newsapi.data.remote.dto.NewsListDto
import com.example.newsapi.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getNewsList(): List<NewsListDto> {
        return api.getNewsList()
    }

    override suspend fun getNewsDetails(id: Int): NewsDetailsDto {
        return api.getNewsDetails(id)
    }

    override suspend fun getBlogsList(): List<BlogsListDto> {
        return api.getBlogsList()
    }
}
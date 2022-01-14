package com.example.newsapi.data.remote

import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.data.remote.dto.NewsDetailsDto
import com.example.newsapi.data.remote.dto.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    @GET("/v3/articles")
    suspend fun getNewsList(): List<NewsListDto>

    @GET("/v3/articles/{id}")
    suspend fun getNewsDetails(@Path("id") id: Int
    ): NewsDetailsDto

    @GET("/v3/blogs")
    suspend fun getBlogsList(): List<BlogsListDto>
}
package com.example.newsapi.data.remote.dto


data class NewsDetailsDto(
    val events: List<Any>,
    val featured: Boolean,
    val id: Int,
    val imageUrl: String,
    val launches: List<Any>,
    val newsSite: String,
    val publishedAt: String,
    val summary: String,
    val title: String,
    val updatedAt: String,
    val url: String
)
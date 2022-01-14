package com.example.newsapi.domain.use_case.news_list_use_case

import com.example.newsapi.common.Resource
import com.example.newsapi.data.remote.dto.NewsListDto
import com.example.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsList @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(): Flow<Resource<List<NewsListDto>>> = flow {
        try {
            emit(Resource.Loading<List<NewsListDto>>())
            val newsList = repository.getNewsList()
            emit(Resource.Success<List<NewsListDto>>(newsList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<NewsListDto>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<NewsListDto>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
package com.example.newsapi.domain.use_case.news_details_list

import com.example.newsapi.common.Resource
import com.example.newsapi.data.remote.dto.NewsDetailsDto
import com.example.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsDetails @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(id: Int): Flow<Resource<NewsDetailsDto>> = flow {
        try {
            emit(Resource.Loading<NewsDetailsDto>())
            val detailsNews = repository.getNewsDetails(id)
            emit(Resource.Success<NewsDetailsDto>(detailsNews))
        } catch (e: HttpException) {
            emit(
                Resource.Error<NewsDetailsDto>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<NewsDetailsDto>("Couldn't reach server. Check your internet connection."))
        }
    }
}
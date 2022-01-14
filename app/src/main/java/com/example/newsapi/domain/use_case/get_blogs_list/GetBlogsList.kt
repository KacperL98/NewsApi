package com.example.newsapi.domain.use_case.get_blogs_list

import com.example.newsapi.common.Resource
import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBlogsList @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(): Flow<Resource<List<BlogsListDto>>> = flow {
        try {
            emit(Resource.Loading<List<BlogsListDto>>())
            val blogList = repository.getBlogsList()
            emit(Resource.Success<List<BlogsListDto>>(blogList))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<BlogsListDto>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<BlogsListDto>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
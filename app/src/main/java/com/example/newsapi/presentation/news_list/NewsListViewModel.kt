package com.example.newsapi.presentation.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.common.Resource
import com.example.newsapi.data.remote.dto.NewsListDto
import com.example.newsapi.domain.use_case.news_list_use_case.GetNewsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsList: GetNewsList
) : ViewModel() {

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    init {
        getNews()
    }

    private fun getNews() {
        getNewsList().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        NewsListState(newsData = (result.data as List<NewsListDto>))
                }
                is Resource.Error -> {
                    _state.value = NewsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
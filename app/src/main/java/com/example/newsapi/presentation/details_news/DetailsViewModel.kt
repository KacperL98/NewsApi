package com.example.newsapi.presentation.details_news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.common.Constants
import com.example.newsapi.common.Resource
import com.example.newsapi.domain.use_case.news_details_list.GetNewsDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getNewsDetails: GetNewsDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(NewsDetailsState())
    val state: State<NewsDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.ID_NEWS)?.let {
            getDetailsNews(it.toInt())
        }
    }

    private fun getDetailsNews(id: Int) {
        getNewsDetails(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsDetailsState(newsDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value = NewsDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = NewsDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
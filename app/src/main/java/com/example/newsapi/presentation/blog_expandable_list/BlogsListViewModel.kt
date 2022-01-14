package com.example.newsapi.presentation.blog_expandable_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.common.Resource
import com.example.newsapi.data.remote.dto.BlogsListDto
import com.example.newsapi.domain.use_case.get_blogs_list.GetBlogsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BlogsListViewModel @Inject constructor(
    private val getBlogsList: GetBlogsList
) : ViewModel() {

    private val _state = mutableStateOf(BlogListState())
    val state: State<BlogListState> = _state
    private val _expandedCardIdsList = MutableStateFlow(listOf<Int>())
    val expandedCardIdsList: StateFlow<List<Int>> get() = _expandedCardIdsList
    init {
        getBlog()
    }

    private fun getBlog() {
        getBlogsList().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        BlogListState(newsData = (result.data as List<BlogsListDto>))
                }
                is Resource.Error -> {
                    _state.value = BlogListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = BlogListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onCardArrowClicked(cardId: Int) {
        _expandedCardIdsList.value = _expandedCardIdsList.value.toMutableList().also { list ->
            if (list.contains(cardId)) list.remove(cardId) else list.add(cardId)
        }
    }
}
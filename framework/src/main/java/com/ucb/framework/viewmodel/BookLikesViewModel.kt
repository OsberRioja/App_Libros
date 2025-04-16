package com.ucb.framework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.model.Book
import com.ucb.domain.usecase.GetLikedBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookLikesViewModel(
    private val getLikedBooksUseCase: GetLikedBooksUseCase
) : ViewModel() {

    private val _likedBooks = MutableStateFlow<List<Book>>(emptyList())
    val likedBooks: StateFlow<List<Book>> = _likedBooks

    fun loadLikedBooks() {
        viewModelScope.launch {
            val books = getLikedBooksUseCase()
            _likedBooks.value = books
        }
    }
}

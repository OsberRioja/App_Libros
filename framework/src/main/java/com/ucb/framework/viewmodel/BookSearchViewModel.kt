package com.ucb.framework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.model.Book
import com.ucb.domain.usecase.SaveLikedBookUseCase
import com.ucb.domain.usecase.SearchBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookSearchViewModel(
    private val searchBooksUseCase: SearchBooksUseCase,
    private val saveLikedBookUseCase: SaveLikedBookUseCase
) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            val result = searchBooksUseCase(query)
            _books.value = result
        }
    }

    fun likeBook(book: Book) {
        viewModelScope.launch {
            saveLikedBookUseCase(book)
        }
    }
}

package com.ucb.domain.usecase

import com.ucb.domain.model.Book
import com.ucb.domain.repository.BookRepository

class SearchBooksUseCase(private val repository: BookRepository) {
    suspend operator fun invoke(query: String): List<Book> {
        return repository.searchBooks(query)
    }
}

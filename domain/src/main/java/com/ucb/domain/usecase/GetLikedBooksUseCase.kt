package com.ucb.domain.usecase

import com.ucb.domain.model.Book
import com.ucb.domain.repository.BookRepository

class GetLikedBooksUseCase(private val repository: BookRepository) {
    suspend operator fun invoke(): List<Book> {
        return repository.getLikedBooks()
    }
}

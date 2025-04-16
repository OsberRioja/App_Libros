package com.ucb.domain.usecase

import com.ucb.domain.model.Book
import com.ucb.domain.repository.BookRepository

class SaveLikedBookUseCase(private val repository: BookRepository) {
    suspend operator fun invoke(book: Book) {
        repository.saveBook(book)
    }
}

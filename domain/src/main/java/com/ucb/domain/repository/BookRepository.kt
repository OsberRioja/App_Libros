package com.ucb.domain.repository

import com.ucb.domain.model.Book

interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
    suspend fun saveBook(book: Book)
    suspend fun getLikedBooks(): List<Book>
}

package com.ucb.data.repository


import com.ucb.data.local.dao.BookDao
import com.ucb.data.remote.BookApiService
import com.ucb.domain.model.Book
import com.ucb.domain.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepositoryImpl(
    private val apiService: BookApiService,
    private val bookDao: BookDao
) : BookRepository {

    override suspend fun searchBooks(query: String): List<Book> = withContext(Dispatchers.IO) {
        val response = apiService.searchBooks(query)
        response.docs.map { it.toBook() }
    }

    override suspend fun saveBook(book: Book) = withContext(Dispatchers.IO) {
        bookDao.insertBook(book)
    }

    override suspend fun getLikedBooks(): List<Book> = withContext(Dispatchers.IO) {
        bookDao.getLikedBooks()
    }
}

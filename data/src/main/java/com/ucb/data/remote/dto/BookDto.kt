package com.ucb.data.remote.dto



import com.ucb.domain.model.Book

data class BookDto(
    val title: String?,
    val author_name: List<String>?,
    val first_publish_year: Int?
) {
    // Mapeo a Modelo de Dominio
    fun toBook(): Book {
        return Book(
            title = title ?: "",
            authors = author_name ?: listOf(),
            publishYear = first_publish_year ?: 0
        )
    }
}

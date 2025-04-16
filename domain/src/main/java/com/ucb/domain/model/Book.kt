package com.ucb.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val authors: List<String>,
    val publishYear: Int
)

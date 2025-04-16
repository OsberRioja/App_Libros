package com.ucb.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucb.data.local.dao.BookDao
import com.ucb.domain.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}

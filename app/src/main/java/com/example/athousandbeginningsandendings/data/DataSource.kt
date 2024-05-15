package com.example.athousandbeginningsandendings.data

import com.example.athousandbeginningsandendings.R
import com.example.athousandbeginningsandendings.books
import com.example.athousandbeginningsandendings.model.Book

class DataSource() {
    fun getBooks(): List<Book> {
        return listOf<Book>(
            Book(1, "Forbidden Fruit", "Roshani Chokshi", R.string.forbidden_fruit_story),
            Book(2, "A Fillipino Folktale", "Maria Makailing", R.string.a_filipino_folktale_story),


        )


    }
   fun getBookById(bookId: Int): Book? {
       return books.find { it.id == bookId }
    }
}
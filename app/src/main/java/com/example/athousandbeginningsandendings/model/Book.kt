package com.example.athousandbeginningsandendings.model

import androidx.annotation.StringRes

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    @StringRes val story: Int
)

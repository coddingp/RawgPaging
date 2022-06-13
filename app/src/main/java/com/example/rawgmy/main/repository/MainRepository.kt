package com.example.rawgmy.main.repository

import com.example.rawgmy.main.model.MainListItems

interface MainRepository {
    suspend fun getResult(genre: String, page: Int): List<MainListItems>
    suspend fun getGenres(): MainListItems.GenresModel
}
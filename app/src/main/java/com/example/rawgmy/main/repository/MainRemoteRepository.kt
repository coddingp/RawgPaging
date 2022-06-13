package com.example.rawgmy.main.repository

import com.example.rawgmy.main.api.GamesApi
import com.example.rawgmy.main.model.MainConverter
import com.example.rawgmy.main.model.MainListItems
import com.example.rawgmy.utils.Utils.API_KEY

class MainRemoteRepository(
    private val api: GamesApi
) : MainRepository {
    override suspend fun getResult(genre:String, page: Int): List<MainListItems> {
        val data = api.getResult(API_KEY, genre, page)
        return MainConverter.fromNetWork(data)
    }
    override suspend fun getGenres(): MainListItems.GenresModel {
        val data = api.getGenres(API_KEY)
        return MainConverter.genresFromNetWork(data)
    }
}
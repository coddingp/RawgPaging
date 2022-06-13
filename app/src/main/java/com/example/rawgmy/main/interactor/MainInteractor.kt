package com.example.rawgmy.main.interactor

import com.example.rawgmy.main.model.MainListItems
import com.example.rawgmy.main.repository.MainRemoteRepository

class MainInteractor(
    private val remoteRepository: MainRemoteRepository
) {
    suspend fun getResults(slug: String, page: Int): List<MainListItems> = remoteRepository.getResult(slug, page)
    suspend fun getGenres() = remoteRepository.getGenres()
}
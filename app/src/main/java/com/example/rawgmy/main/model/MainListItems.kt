package com.example.rawgmy.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class MainListItems : Parcelable {
    @Parcelize
    data class Board(
        val title: String,
        val content: List<MainListItems>
    ) : MainListItems()

    @Parcelize
    data class GameText(
        val textTitle: String,
        val textDescription: String
    ) : MainListItems()

    @Parcelize
    data class GameImage(
        val image: String,
        val textTitle: String
    ) : MainListItems()

    @Parcelize
    data class Game(
        val id: Int,
        val slug: String,
        val image: String,
        val textTitle: String,
        val rating: Float
    ) : MainListItems()

    @Parcelize
    data class GenresModel(
        val count: Int,
        val next: String?,
        val previous: String?,
        val genresNames: List<GenresNames>
    ) : MainListItems()

    @Parcelize
    data class GenresNames(
        val name: String?,
        val slug: String,
        var gamsList: MutableList<MainListItems> = mutableListOf(),
        var position: Int = -1,
        var page: Int = 1
    ) : MainListItems()

    @Parcelize
    data class GenreGame(
        val added: Int,
        val id: Int,
        val name: String,
        val slug: String
    ) : MainListItems()
}

package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class GenresDetailedResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
    @SerializedName("image_background")
    val imageBackground: String,
    @SerializedName("games")
    val gameNames: List<GameNamesResponse>
)

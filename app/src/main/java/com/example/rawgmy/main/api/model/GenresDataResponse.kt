package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName


data class GenresDataResponse(
    @SerializedName("id")
    val id: Short,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("games_count")
    val gamesCount: Int,
    @SerializedName("image_background")
    val imageBackground: String
)
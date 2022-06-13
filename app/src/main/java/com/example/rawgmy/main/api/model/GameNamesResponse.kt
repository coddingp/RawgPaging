package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class GameNamesResponse(
    @SerializedName("id")
    val gameId: Int,
    @SerializedName("slug")
    val gameSlug: String,
    @SerializedName("name")
    val gameName: String,
    @SerializedName("added")
    val gameAdded: Int
)

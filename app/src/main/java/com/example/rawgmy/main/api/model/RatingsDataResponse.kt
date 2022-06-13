package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class RatingsDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("percent")
    val percent: Float
)
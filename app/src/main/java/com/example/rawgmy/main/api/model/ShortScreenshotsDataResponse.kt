package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class ShortScreenshotsDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)
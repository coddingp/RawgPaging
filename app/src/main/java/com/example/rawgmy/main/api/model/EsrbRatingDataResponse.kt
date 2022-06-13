package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class EsrbRatingDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)

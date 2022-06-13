package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class YearsDetailedResponse(
    @SerializedName("year")
    val year: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("nofollow")
    val nofollow: Boolean
)
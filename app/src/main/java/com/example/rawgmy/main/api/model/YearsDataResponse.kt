package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class YearsDataResponse(
    @SerializedName("from")
    val from: Int,
    @SerializedName("to")
    val to: Int,
    @SerializedName("filter")
    val filter: String,
    @SerializedName("decade")
    val decade: Int,
    @SerializedName("years")
    val years: List<YearsDetailedResponse>,
    @SerializedName("nofollow")
    val nofollow: Boolean,
    @SerializedName("count")
    val count: Int
)
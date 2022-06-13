package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName


data class RequirementsEnResponse(
    @SerializedName("minimum")
    val minimum: String?,
    @SerializedName("recommended")
    val recommended: String?
)
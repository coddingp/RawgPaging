package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName


data class ParentGamePlatformResponse(
    @SerializedName("platform")
    val platformResponse: ParentGamePlatformDataResponse
)
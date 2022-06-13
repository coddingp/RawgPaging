package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class GamePlatformDataResponse(
    @SerializedName("platform")
    val platformResponse: GeneralPlatformDataResponse,
    @SerializedName("released_at")
    val releasedAt: String,
    @SerializedName("requirements_en")
    val requirementsEnResponse: RequirementsEnResponse?,
    @SerializedName("requirements_ru")
    val requirementsRuResponse: RequirementsRuResponse?
)
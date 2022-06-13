package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class FiltersDataResponse(
    @SerializedName("years")
    val years: List<YearsDataResponse>
)
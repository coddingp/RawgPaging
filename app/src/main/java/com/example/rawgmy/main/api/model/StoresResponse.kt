package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class StoresResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("store")
    val storeResponse: StoreDataResponse
)
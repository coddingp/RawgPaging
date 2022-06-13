package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName


data class GeneralDataResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val resultsResponse: List<GameDataResponse>,
    @SerializedName("seo_title")
    val seoTitle: String,
    @SerializedName("seo_description")
    val seoDescription: String,
    @SerializedName("seo_keywords")
    val seoKeywords: String,
    @SerializedName("seo_h1")
    val seoH1: String,
    @SerializedName("noindex")
    val noIndex: Boolean,
    @SerializedName("nofollow")
    val noFollow: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("filters")
    val filtersResponse: FiltersDataResponse,
    @SerializedName("nofollow_collections")
    val noFollowCollections: List<String>
)
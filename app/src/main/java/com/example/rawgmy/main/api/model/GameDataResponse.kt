package com.example.rawgmy.main.api.model

import com.google.gson.annotations.SerializedName

data class GameDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("tba")
    val tba: Boolean,
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("rating")
    val rating: Float,
    @SerializedName("rating_top")
    val ratingTop: Int,
    @SerializedName("ratings")
    val ratings: List<RatingsDataResponse>,
    @SerializedName("ratings_count")
    val ratingsCount: Int,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int,
    @SerializedName("added")
    val added: Int,
    @SerializedName("added_by_status")
    val addedStatus: GameStatusResponse,
    @SerializedName("metacritic")
    val metaCritic: Int,
    @SerializedName("playtime")
    val playtime: Int,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("user_game")
    val userGame: String?,
    @SerializedName("reviews_count")
    val reviewsCount: Int,
    @SerializedName("saturated_color")
    val saturatedColor: String,
    @SerializedName("dominant_color")
    val dominantColor: String,
    @SerializedName("platforms")
    val platformResponse: List<GamePlatformDataResponse>,
    @SerializedName("parent_platforms")
    val parentPlatformResponse: List<ParentGamePlatformResponse>,
    @SerializedName("genres")
    val genres: List<GenresDataResponse>,
    @SerializedName("stores")
    val stores: List<StoresResponse>,
    @SerializedName("clip")
    val clip: String?,
    @SerializedName("tags")
    val tags: List<GameTagsResponse>,
    @SerializedName("esrb_rating")
    val esrbRatingResponse: EsrbRatingDataResponse?,
    @SerializedName("short_screenshots")
    val shortScreenshotResponses: List<ShortScreenshotsDataResponse>
)
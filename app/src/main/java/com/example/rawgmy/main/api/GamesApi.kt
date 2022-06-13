package com.example.rawgmy.main.api

import com.example.rawgmy.main.api.model.GeneralDataResponse
import com.example.rawgmy.main.api.model.GenresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("games")
    suspend fun getResult(
        @Query("key") key: String,
        @Query("genres") genres: String,
        @Query("page") page: Int
    ): GeneralDataResponse

    @GET("genres")
    suspend fun getGenres(
        @Query("key") key: String
    ): GenresResponse


}
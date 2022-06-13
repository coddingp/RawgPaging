package com.example.rawgmy.main.model

import com.example.rawgmy.main.api.model.GeneralDataResponse
import com.example.rawgmy.main.api.model.GenresDetailedResponse
import com.example.rawgmy.main.api.model.GenresResponse


object MainConverter {


    fun fromNetWork(response: GeneralDataResponse): List<MainListItems> {
        val game =
            response.resultsResponse.map {
                MainListItems.Game(
                    id = it.id,
                    image = it.backgroundImage,
                    textTitle = it.name,
                    rating = it.rating,
                    slug = it.slug
                )
            }
        val gameWithText =
            response.resultsResponse.map {
                MainListItems.GameText(
                    textTitle = it.name,
                    textDescription = it.released
                )
            }

        val gameWithSmallImage =
            response.resultsResponse.map {
                MainListItems.GameImage(
                    image = it.backgroundImage,
                    textTitle = it.name
                )
            }
        return (game /*+ gameWithText + gameWithSmallImage*/)
    }

    fun genresFromNetWork(response: GenresResponse) =
        MainListItems.GenresModel(
            count = response.count,
            next = response.next,
            previous = response.previous,
            genresNames = genresResultsFromNetWork(response.results)
        )

    private fun genresResultsFromNetWork(response: List<GenresDetailedResponse>) =
        response.map {
            MainListItems.GenresNames(
                name = it.name,
                slug = it.slug
            )
        }
}
package com.example.rawgmy.main.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.rawgmy.common.mvp.BasePresenter
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.main.interactor.MainInteractor
import com.example.rawgmy.main.model.MainListItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter(
    private val interactor: MainInteractor,
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val game = mutableListOf<MainListItems>()
    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)
    private var paginationEnded = false

    override fun getGamesList(data: MainListItems.GenresNames, page: Int) {
        if (paginationEnded) return
        presenterScope.launch {
            try {
                view?.showPagingState(PagingState.Loading)
                val games = interactor.getResults(data.slug, data.page)
                if (games.isEmpty()) {
                    paginationEnded = true
                } else {
                    game.addAll(games)
                    val allGames = game.distinctBy { it }
                    view?.showGamesList(listOf(allGames[page]), page)
                }
                view?.showPagingState(PagingState.Idle)
                Timber.tag("%%%").i("data:  $games")
                view?.showGamesList(games, data.position)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            } catch (e: Throwable) {
                Timber.e(e, "Error loading games by page")
                view?.showPagingState(PagingState.Error(e))
            }
        }
    }

    override fun getGenresList() {
        presenterScope.launch {
            try {
                val data = interactor.getGenres()
                view?.showGenresList(data)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }

    override fun refresh(page: Int, genres: String) {
        TODO("Not yet implemented")
    }

    private fun getDiffCallback(
        oldList: List<MainListItems.GenreGame>,
        newList: List<MainListItems.GenreGame>
    ) = object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val old = oldList[oldItemPosition]
            val new = newList[newItemPosition]
            return old == new
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size
    }

}
package com.example.rawgmy.main.ui

import com.example.rawgmy.common.mvp.BaseFragmentContract
import com.example.rawgmy.common.mvp.MvpPresenter
import com.example.rawgmy.common.mvp.MvpView
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.main.model.MainListItems

interface MainContract : BaseFragmentContract {
    interface View : MvpView {
        fun showGamesList(data: List<MainListItems>, position: Int)
        fun showGenresList(data: MainListItems.GenresModel)
        fun showPagingState(pagingState: PagingState)
        fun showLoading(isLoading: Boolean)
        fun showRefreshing(isRefreshing: Boolean)
    }

    interface Presenter : MvpPresenter<View> {
        fun getGamesList(data: MainListItems.GenresNames, page: Int)
        fun getGenresList()
        fun refresh(page: Int = 1, genres: String)
    }
}
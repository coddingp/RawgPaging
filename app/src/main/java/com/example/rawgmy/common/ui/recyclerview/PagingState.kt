package com.example.rawgmy.common.ui.recyclerview

sealed class PagingState {
    object Idle : PagingState()
    object Loading : PagingState()
    object InitialLoading : PagingState()
    object Refreshing : PagingState()
    class Error(val e: Throwable) : PagingState()
}
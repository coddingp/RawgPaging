package com.example.rawgmy.main.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.main.model.MainListItems

private const val VISIBLE_THRESHOLD = 10

class MainScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadNextPage: (MainListItems.GenresNames) -> Unit,
    private val genersNames: MainListItems.GenresNames
) : RecyclerView.OnScrollListener() {

    private var isLoading = true
    private var totalLoadedItems = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (totalItemCount == visibleItemCount) return

        if (totalItemCount > totalLoadedItems) {
            isLoading = false
            totalLoadedItems = totalItemCount
            return
        }

        val shouldLoadMore = totalItemCount - visibleItemCount <= firstVisibleItem + VISIBLE_THRESHOLD
        if (!isLoading && shouldLoadMore) {
            genersNames.page++
            loadNextPage(genersNames)
            isLoading = true
        }
    }

    fun reset() {
        isLoading = false
        totalLoadedItems = 0
        genersNames.page = 1
    }
}
package com.example.rawgmy.main.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.R
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.main.model.MainListItems
import timber.log.Timber

class BoardAdapter(
    private val getGamesNewGenre: (MainListItems.GenresNames) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var pagingState: PagingState = PagingState.Idle
    private var noAdditionalItemRequiredState = listOf<PagingState.Idle>()
    private val genresData = mutableListOf<MainListItems.GenresNames>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BoardViewHolder(parent, pagingState, getGamesNewGenre)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BoardViewHolder -> holder.bind(
                item = genresData[position],
                position
            )
            is ProgressViewHolder -> Unit
        }
    }

    override fun getItemCount() = genresData.size

    fun setItems(list: List<MainListItems>, position: Int) {
        genresData[position].gamsList.addAll(list)
        notifyDataSetChanged()
    }

    fun setPagingState(newState: PagingState) {
        if (pagingState::class.java == newState::class.java) return
        val shouldHasExtraItem = newState !is PagingState.Idle
        val hasExtraItem = pagingState !is PagingState.Idle
        pagingState = newState

        val count = itemCount
        when {
            hasExtraItem && shouldHasExtraItem -> notifyItemChanged(count - 1)
            hasExtraItem && !shouldHasExtraItem -> notifyItemRemoved(count - 1)
            !hasExtraItem && shouldHasExtraItem -> notifyItemInserted(count)
        }
    }

    private fun stateRequiresExtraItem(state: PagingState) = state !in noAdditionalItemRequiredState

    fun setGenres(list: List<MainListItems.GenresNames>) {
        genresData.addAll(list)
        Timber.i("Data: $genresData")
        notifyDataSetChanged()
    }
}
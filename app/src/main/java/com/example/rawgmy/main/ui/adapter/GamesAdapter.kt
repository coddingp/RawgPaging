package com.example.rawgmy.main.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.R
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.main.model.MainListItems

class GamesAdapter(private var pagingState: PagingState) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<MainListItems>()
    private var noAdditionalItemRequiredState = listOf<PagingState.Idle>()
    override fun getItemViewType(position: Int): Int = when {
        pagingState is PagingState.Loading || pagingState is PagingState.InitialLoading -> R.layout.item_progress_bar
        else -> {
            when (data[position]) {
                is MainListItems.Game -> R.layout.item_game
                is MainListItems.GameImage -> R.layout.item_game_image
                is MainListItems.GameText -> R.layout.item_game_text
                else -> {
                    throw IllegalStateException("Type not found")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            R.layout.item_game -> GameViewHolder(parent)
            R.layout.item_game_image -> GameWithImageViewHolder(parent)
            R.layout.item_progress_bar -> ProgressViewHolder(parent)
            R.layout.item_game_text -> GameWithTextViewHolder(parent)
            else -> throw IllegalStateException("Unknown view type: $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GameViewHolder -> holder.bind(item = data[position] as MainListItems.Game)
            is GameWithImageViewHolder -> holder.bind(item = data[position] as MainListItems.GameImage)
            is GameWithTextViewHolder -> holder.bind(item = data[position] as MainListItems.GameText)
        }
    }

    private fun stateRequiresExtraItem(state: PagingState) = state !in noAdditionalItemRequiredState

    override fun getItemCount() = data.size

    fun setItems(list: List<MainListItems>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun clearItems() {
        val itemsCount = data.size
        data.clear()
        notifyItemRangeRemoved(0, itemsCount)
    }
}
package com.example.rawgmy.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.databinding.ItemBoardBinding
import com.example.rawgmy.main.model.MainListItems
import com.example.rawgmy.main.ui.MainScrollListener
import timber.log.Timber

class BoardViewHolder(
    private val binding: ItemBoardBinding,
    private var pagingState: PagingState,
    private val getGamesNewGenre: (MainListItems.GenresNames) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val gamesAdapter: GamesAdapter by lazy {
        GamesAdapter(pagingState)
    }

    constructor(
        parent: ViewGroup,
        pagingState: PagingState,
        getGamesNewGenre: (MainListItems.GenresNames) -> Unit
    ) : this(
        ItemBoardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
        pagingState,
        getGamesNewGenre
    )

    init {
        with(binding.recyclerViewForItems) {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = gamesAdapter
        }
    }

    fun bind(item: MainListItems.GenresNames, position: Int) {
        with(binding) {
            recyclerViewForItems.addOnScrollListener(
                MainScrollListener(
                    recyclerViewForItems.layoutManager as LinearLayoutManager,
                    getGamesNewGenre,
                    item
                )
            )
            titleTextView.text = item.name
            if (item.position == -1) {
                item.position = position
                getGamesNewGenre(item)
            }
            gamesAdapter.setItems(item.gamsList)
            Timber.i("${item.name}")
        }
    }

}
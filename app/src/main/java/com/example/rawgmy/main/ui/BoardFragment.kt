package com.example.rawgmy.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rawgmy.R
import com.example.rawgmy.common.mvp.BaseFragmentMvp
import com.example.rawgmy.common.ui.recyclerview.PagingState
import com.example.rawgmy.databinding.BoardBinding
import com.example.rawgmy.main.model.MainListItems
import com.example.rawgmy.main.ui.adapter.BoardAdapter
import org.koin.android.ext.android.inject

class BoardFragment :
    BaseFragmentMvp<MainContract.View, MainContract.Presenter>(R.layout.item_board),
    MainContract.View {

    private lateinit var binding: BoardBinding

    override val presenter: MainPresenter by inject()
    private val boardAdapter: BoardAdapter by lazy {
        BoardAdapter(getGamesNewGenre = {
            getGamesNewGenre(it, it.page)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerViewForRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewForRecyclerView.adapter = boardAdapter
            presenter.getGenresList()
        }
    }

    override fun showGamesList(data: List<MainListItems>, position: Int) {
        boardAdapter.setItems(data, position)
    }

    override fun showGenresList(data: MainListItems.GenresModel) {
        boardAdapter.setGenres(data.genresNames)
    }

    override fun showPagingState(pagingState: PagingState) {
        boardAdapter.setPagingState(pagingState)
    }

    override fun showLoading(isLoading: Boolean) {
        with(binding) {
            recyclerViewForRecyclerView.isVisible = !isLoading
            swipeRefresh.isVisible = isLoading
        }
    }

    override fun showRefreshing(isRefreshing: Boolean) {
        TODO("Not yet implemented")
    }


    private fun getGamesNewGenre(data: MainListItems.GenresNames, page:Int) =
        presenter.getGamesList(data, page)
}
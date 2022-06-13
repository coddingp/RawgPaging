package com.example.rawgmy.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawgmy.R
import com.example.rawgmy.databinding.ItemGameBinding
import com.example.rawgmy.main.model.MainListItems

class GameViewHolder(
    private val binding: ItemGameBinding,
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemGameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    fun bind(item: MainListItems.Game) {
        with(binding) {
            Glide.with(root.context).load(item.image).placeholder(R.drawable.lanscape_placeholder).into(iconImageView)
            titleTextView.text = item.textTitle
            ratingBar.rating = item.rating
        }
    }
}
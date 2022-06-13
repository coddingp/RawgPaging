package com.example.rawgmy.main.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rawgmy.R
import com.example.rawgmy.databinding.ItemGameImageBinding
import com.example.rawgmy.main.model.MainListItems

class GameWithImageViewHolder(
    private val binding: ItemGameImageBinding,
) : RecyclerView.ViewHolder(binding.root) {


    constructor(parent: ViewGroup) : this(
        ItemGameImageBinding.inflate(LayoutInflater.from(parent.context), parent, false
        )
    )

    fun bind(item: MainListItems.GameImage) {
        with(binding) {
            Glide.with(root.context).load(item.image).placeholder(R.drawable.lanscape_placeholder).into(iconImageView)
            titleTextView.text = item.textTitle
        }
    }
}
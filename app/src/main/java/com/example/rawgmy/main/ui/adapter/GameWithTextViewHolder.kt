package com.example.rawgmy.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.databinding.ItemGameTextBinding
import com.example.rawgmy.main.model.MainListItems

class GameWithTextViewHolder(
    private val binding: ItemGameTextBinding,
) : RecyclerView.ViewHolder(binding.root) {


    constructor(parent: ViewGroup) : this(
        ItemGameTextBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    fun bind(item: MainListItems.GameText) {
        with(binding) {
            titleTextView.text = item.textTitle
            descriptionTextView.text = item.textDescription
        }
    }
}
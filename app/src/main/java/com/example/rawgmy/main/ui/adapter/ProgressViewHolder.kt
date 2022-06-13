package com.example.rawgmy.main.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rawgmy.databinding.ItemProgressBarBinding

class ProgressViewHolder(
    binding: ItemProgressBarBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemProgressBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}
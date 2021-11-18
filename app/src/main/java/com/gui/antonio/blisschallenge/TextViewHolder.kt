package com.gui.antonio.blisschallenge

import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.blisschallenge.databinding.ItemTextBinding

class TextViewHolder(private val itemTextBinding: ItemTextBinding) : RecyclerView.ViewHolder(itemTextBinding.root) {

    fun bind(repository: String) {
        itemTextBinding.nameRepositoryTextView.text = repository
    }

}
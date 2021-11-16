package com.gui.antonio.blisschallenge

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gui.antonio.blisschallenge.databinding.ItemImageBinding

class ImageViewHolder(private val imageBinding: ItemImageBinding) : RecyclerView.ViewHolder(imageBinding.root) {

    fun bind(url: String) {
        Glide.with(itemView).load(url).into(imageBinding.iconGitImageView)
    }


}
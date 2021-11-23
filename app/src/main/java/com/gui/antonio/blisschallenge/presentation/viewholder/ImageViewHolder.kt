package com.gui.antonio.blisschallenge.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gui.antonio.blisschallenge.databinding.ItemImageBinding

class ImageViewHolder(
    private val imageBinding: ItemImageBinding,
    private val imageOnClick: (Int) -> Unit
) : RecyclerView.ViewHolder(imageBinding.root) {

    fun bind(url: String, position: Int) {
        Glide.with(itemView).load(url).into(imageBinding.iconGitImageView)
        imageBinding.iconGitImageView.setOnClickListener { imageOnClick.invoke(position) }
    }

}
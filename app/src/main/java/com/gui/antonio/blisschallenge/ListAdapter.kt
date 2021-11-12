package com.gui.antonio.blisschallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.blisschallenge.databinding.ItemImageBinding
import com.gui.antonio.blisschallenge.databinding.ItemTextBinding

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                ImageViewHolder(
                    ItemImageBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            else -> {
                TextViewHolder(
                    ItemTextBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }
}
package com.gui.antonio.blisschallenge

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.LayoutInflaterCompat
import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.blisschallenge.databinding.ItemImageBinding
import com.gui.antonio.blisschallenge.databinding.ItemTextBinding

class ListAdapter(
    private val listType: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<String> = ArrayList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

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
        when (holder) {
            is ImageViewHolder -> {
                holder.bind(items[position])
            }
            is TextViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return listType
    }
}
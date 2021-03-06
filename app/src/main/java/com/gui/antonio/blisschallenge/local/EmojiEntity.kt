package com.gui.antonio.blisschallenge.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emoji")
data class EmojiEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val url: String
)
package com.gui.antonio.blisschallenge

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "avatar")
data class AvatarEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val url: String
)
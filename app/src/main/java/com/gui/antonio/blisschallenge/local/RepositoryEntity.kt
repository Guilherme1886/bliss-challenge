package com.gui.antonio.blisschallenge.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository")
data class RepositoryEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val name: String
)
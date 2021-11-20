package com.gui.antonio.blisschallenge

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "app_database"

@Database(
    entities = [EmojiEntity::class, AvatarEntity::class, RepositoryEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
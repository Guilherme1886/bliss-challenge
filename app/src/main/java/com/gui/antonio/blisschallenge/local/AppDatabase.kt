package com.gui.antonio.blisschallenge.local

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_NAME = "app_database"
const val DATABASE_VERSION = 1

@Database(
    entities = [EmojiEntity::class, AvatarEntity::class, RepositoryEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
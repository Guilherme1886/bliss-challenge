package com.gui.antonio.blisschallenge

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM emoji")
    suspend fun getEmoji(): List<EmojiEntity>

    @Insert
    suspend fun insertEmojis(emojis: List<EmojiEntity>)

    @Query("SELECT * FROM avatar")
    suspend fun getAvatar(): AvatarEntity

    @Insert
    suspend fun insertAvatar(avatars: AvatarEntity)

    @Query("SELECT * FROM repository")
    suspend fun getRepository(): List<RepositoryEntity>

    @Insert
    suspend fun insertRepositories(repositories: List<RepositoryEntity>)

}
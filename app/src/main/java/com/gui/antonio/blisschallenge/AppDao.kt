package com.gui.antonio.blisschallenge

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM emoji")
    fun getEmoji(): List<EmojiEntity>

    @Insert
    fun insertEmojis(emojis: List<EmojiEntity>)

    @Query("SELECT * FROM avatar")
    fun getAvatar(): List<AvatarEntity>

    @Insert
    fun insertAvatar(avatars: List<AvatarEntity>)

    @Query("SELECT * FROM repository")
    fun getRepository(): List<RepositoryEntity>

    @Insert
    fun insertRepositories(repositories: List<RepositoryEntity>)

}
package com.gui.antonio.blisschallenge

class GitHubRepository(private val service: GitHubService) {

    //todo: INJECT USING HILT IN THE CONSTRUCTOR
    private val db = MainApplication.db

    suspend fun getEmojis(): MutableList<EmojiPresentation> {

        val emojisFromdb = db?.appDao()?.getEmoji()

        if (emojisFromdb?.isEmpty() == true) {
            val emojis = service.getEmojis()
            val emojisEntity = listOf(
                EmojiEntity(url = emojis.body()?.get("accept")?.asString ?: ""),
                EmojiEntity(url = emojis.body()?.get("balloon")?.asString ?: ""),
                EmojiEntity(url = emojis.body()?.get("amphora")?.asString ?: ""),
                EmojiEntity(url = emojis.body()?.get("arrow_lower_left")?.asString ?: ""),
            )

            db?.appDao()?.insertEmojis(emojisEntity)

            val e = db?.appDao()?.getEmoji()

            if (e?.isNotEmpty() == true) {
                return e.map {
                    EmojiPresentation(it.url)
                }.toMutableList()
            }

            return emptyList<EmojiPresentation>().toMutableList()
        } else {
            return emojisFromdb?.map { EmojiPresentation(it.url) }!!.toMutableList()
        }
    }

    suspend fun getUserData(): AvatarPresentation {
        val avatarFromDB = db?.appDao()?.getAvatar()

        if (avatarFromDB == null) {
            val avatarFromAPI = service.getUserData().body()?.get("avatar_url")?.asString
            db?.appDao()?.insertAvatar(AvatarEntity(url = avatarFromAPI ?: ""))

            val b = db?.appDao()?.getAvatar()

            if (b != null) {
                return AvatarPresentation(b.url)
            }
            return AvatarPresentation("")
        } else {
            return AvatarPresentation(avatarFromDB.url)
        }
    }

    suspend fun getUserRepo(): MutableList<RepositoryPresentation> {
        val userFromDB = db?.appDao()?.getRepository()

        if (userFromDB?.isEmpty() == true) {
            val repoFromAPI = service.getUserRepo()
            val i = repoFromAPI.body()?.map {
                RepositoryEntity(name = it.asJsonObject["full_name"].asString)
            }
            db?.appDao()?.insertRepositories(i!!)

            return db?.appDao()?.getRepository()?.map {
                RepositoryPresentation(name = it.name)
            }!!.toMutableList()
        } else {
            return userFromDB?.map {
                RepositoryPresentation(it.name)
            }!!.toMutableList()
        }

    }
}
package com.gui.antonio.blisschallenge

class GitHubRepository(private val service: GitHubService) {

    suspend fun getEmojis() = service.getEmojis()

    suspend fun getUserData() = service.getUserData()

    suspend fun getUserRepo() = service.getUserRepo()

}
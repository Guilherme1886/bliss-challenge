package com.gui.antonio.blisschallenge

class GetEmojisUseCase(private val repository: GitHubRepository) {

    suspend fun getEmojis() = repository.getEmojis()

}
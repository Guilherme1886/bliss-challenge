package com.gui.antonio.blisschallenge.data

class GetEmojisUseCase(private val repository: GitHubRepository) {

    suspend fun getEmojis() = repository.getEmojis()

}
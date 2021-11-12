package com.gui.antonio.blisschallenge

class GetEmojisUseCase(private val repository: GitHubRepository) {

    fun getEmojis(){
        repository.getEmojis()
    }
}
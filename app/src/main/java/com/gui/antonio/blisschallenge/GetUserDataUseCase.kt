package com.gui.antonio.blisschallenge

class GetUserDataUseCase(private val repository: GitHubRepository) {

    fun getUserData(username: String) {
        repository.getUserData(username)
    }
}
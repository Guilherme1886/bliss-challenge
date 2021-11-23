package com.gui.antonio.blisschallenge.data

class GetUserDataUseCase(private val repository: GitHubRepository) {

    suspend fun getUserData(username: String? = null) = repository.getUserData(username)
}
package com.gui.antonio.blisschallenge

class GetUserDataUseCase(private val repository: GitHubRepository) {

    suspend fun getUserData() = repository.getUserData()
}
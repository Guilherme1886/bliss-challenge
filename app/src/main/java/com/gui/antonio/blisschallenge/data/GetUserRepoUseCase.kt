package com.gui.antonio.blisschallenge.data

class GetUserRepoUseCase(private val repository: GitHubRepository) {

    suspend fun getUserRepo() = repository.getUserRepo()

}
package com.gui.antonio.blisschallenge

class GetUserRepoUseCase(private val repository: GitHubRepository) {

    suspend fun getUserRepo() = repository.getUserRepo()

}
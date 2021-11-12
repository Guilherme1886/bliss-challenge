package com.gui.antonio.blisschallenge

class GetUserRepoUseCase(private val repository: GitHubRepository) {

    fun getUserRepo(username: String) {
        repository.getUserRepo(username)
    }
}
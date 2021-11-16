package com.gui.antonio.blisschallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val service = ClientRetrofit.get()?.create(GitHubService::class.java)
        val repository = GitHubRepository(service!!)
        val emojisUseCase = GetEmojisUseCase(repository)
        val userDataUseCase = GetUserDataUseCase(repository)
        val userRepoUseCase = GetUserRepoUseCase(repository)

        return MainViewModel(emojisUseCase, userDataUseCase, userRepoUseCase) as T
    }
}
package com.gui.antonio.blisschallenge.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gui.antonio.blisschallenge.data.GetEmojisUseCase
import com.gui.antonio.blisschallenge.data.GetUserDataUseCase
import com.gui.antonio.blisschallenge.data.GetUserRepoUseCase
import com.gui.antonio.blisschallenge.data.GitHubRepository
import com.gui.antonio.blisschallenge.network.ClientRetrofit
import com.gui.antonio.blisschallenge.network.GitHubService
import com.gui.antonio.blisschallenge.presentation.viewmodel.MainViewModel

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
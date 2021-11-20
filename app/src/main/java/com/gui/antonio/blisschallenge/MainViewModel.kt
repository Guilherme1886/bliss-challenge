package com.gui.antonio.blisschallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getEmojisUseCase: GetEmojisUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getUserRepoUseCase: GetUserRepoUseCase,
) : ViewModel() {

    private val _getEmojisLiveData = MutableLiveData<MutableList<String>>()
    var getEmojisLiveData: LiveData<MutableList<String>> = _getEmojisLiveData

    private val _getAvatarLiveData = MutableLiveData<MutableList<String>>()
    var getAvatarLiveData: LiveData<MutableList<String>> = _getAvatarLiveData

    private val _getReposLiveData = MutableLiveData<MutableList<String>>()
    var getReposLiveData: LiveData<MutableList<String>> = _getReposLiveData

    var typeList = -1

    fun getEmojis() {
        viewModelScope.launch(Dispatchers.IO) {
            val emojis = getEmojisUseCase.getEmojis().map {
                it.emoji
            }.toMutableList()
            _getEmojisLiveData.postValue(emojis)
        }
    }

    fun getAvatar() {
        viewModelScope.launch(Dispatchers.IO) {
            val avatar = getUserDataUseCase.getUserData()
            _getAvatarLiveData.postValue(mutableListOf(avatar.url ?: ""))
        }
    }

    fun getRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            val repos = getUserRepoUseCase.getUserRepo()
            val repositories = repos.map {
                it.name
            }.toMutableList()
            _getReposLiveData.postValue(repositories)
        }
    }

}
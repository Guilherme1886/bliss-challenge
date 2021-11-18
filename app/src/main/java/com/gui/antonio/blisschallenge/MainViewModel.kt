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
            val emojis = getEmojisUseCase.getEmojis()
            _getEmojisLiveData.postValue(
                mutableListOf(
                    emojis.body()?.get("accept")?.asString ?: "",
                    emojis.body()?.get("balloon")?.asString ?: "",
                    emojis.body()?.get("amphora")?.asString ?: "",
                    emojis.body()?.get("arrow_lower_left")?.asString ?: "",
                    emojis.body()?.get("athletic_shoe")?.asString ?: "",
                    emojis.body()?.get("auto_rickshaw")?.asString ?: "",
                    emojis.body()?.get("bullettrain_side")?.asString ?: "",
                    emojis.body()?.get("british_indian_ocean_territory")?.asString ?: ""
                )
            )
        }
    }

    fun getAvatar() {
        viewModelScope.launch(Dispatchers.IO) {
            val avatar = getUserDataUseCase.getUserData()
            _getAvatarLiveData.postValue(mutableListOf(avatar.body()?.get("avatar_url")!!.asString))
        }
    }

    fun getRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            val repos = getUserRepoUseCase.getUserRepo()
            val items = repos.body()?.map { it.asJsonObject["full_name"].asString }
            _getReposLiveData.postValue(items?.toMutableList())
        }
    }

}
package com.gui.antonio.blisschallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val getEmojisUseCase: GetEmojisUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getUserRepoUseCase: GetUserRepoUseCase,
) : ViewModel() {

    private val _getEmojisLiveData = MutableLiveData<Any>()
    var getEmojisLiveData: LiveData<Any> = _getEmojisLiveData

    fun getEmojis() {
        getEmojisUseCase.getEmojis()
        _getEmojisLiveData.value = ""
    }
}
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

}
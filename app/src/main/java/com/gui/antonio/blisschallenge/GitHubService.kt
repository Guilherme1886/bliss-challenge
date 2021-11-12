package com.gui.antonio.blisschallenge

interface GitHubService {

    fun getEmojis()
    fun getUserData(username: String)
    fun getUserRepo(username: String)

}
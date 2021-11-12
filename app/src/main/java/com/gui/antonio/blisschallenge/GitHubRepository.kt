package com.gui.antonio.blisschallenge

class GitHubRepository(private val service: GitHubService?) {

    fun getEmojis() {
        service!!.getEmojis()
    }

    fun getUserData(username: String) {
        service!!.getUserData(username)
    }

    fun getUserRepo(username: String) {
        service!!.getUserRepo(username)
    }


}
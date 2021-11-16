package com.gui.antonio.blisschallenge

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET

interface GitHubService {

    @GET("/emojis")
    suspend fun getEmojis(): Response<JsonObject>
    fun getUserData(username: String)
    fun getUserRepo(username: String)

}
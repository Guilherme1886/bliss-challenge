package com.gui.antonio.blisschallenge.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/emojis")
    suspend fun getEmojis(): Response<JsonObject>

    @GET("/users/{username}")
    suspend fun getUserData(@Path("username") username: String): Response<JsonObject>

    @GET("/users/{username}/repos")
    suspend fun getUserRepo(@Path("username") username: String = "google"): Response<JsonArray>

}
package com.gui.antonio.blisschallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

import com.google.gson.Gson




object ClientRetrofit {

    var retrofit: Retrofit? = null

    fun get(): Retrofit? {
        if (retrofit == null) {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}
package com.gui.antonio.blisschallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
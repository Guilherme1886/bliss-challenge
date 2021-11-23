package com.gui.antonio.blisschallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ClientRetrofit {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://api.github.com"

    fun get(): Retrofit? {
        if (retrofit == null) {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}
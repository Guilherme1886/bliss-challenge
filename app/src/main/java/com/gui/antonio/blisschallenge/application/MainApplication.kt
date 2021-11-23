package com.gui.antonio.blisschallenge.application

import android.app.Application
import androidx.room.Room
import com.gui.antonio.blisschallenge.local.AppDatabase
import com.gui.antonio.blisschallenge.local.DATABASE_NAME

class MainApplication : Application() {

    companion object {
        var db: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        if (db == null) db =
            Room.databaseBuilder(this, AppDatabase::class.java, DATABASE_NAME).build()
    }
}
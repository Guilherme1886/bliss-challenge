package com.gui.antonio.blisschallenge

import android.app.Application
import androidx.room.Room

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
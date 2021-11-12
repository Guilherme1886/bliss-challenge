package com.gui.antonio.blisschallenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showListActivity(context: Context) {
    startActivity(Intent(context, ListActivity::class.java))
}
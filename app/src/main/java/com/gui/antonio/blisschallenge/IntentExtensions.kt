package com.gui.antonio.blisschallenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

const val KEY_TYPE = "KEY_TYPE"

fun AppCompatActivity.showListActivity(context: Context, type: String) {
    startActivity(
        Intent(context, ListActivity::class.java)
            .putExtra(KEY_TYPE, type)
    )
}
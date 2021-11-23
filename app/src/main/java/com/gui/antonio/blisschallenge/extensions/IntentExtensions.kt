package com.gui.antonio.blisschallenge.extensions

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.gui.antonio.blisschallenge.presentation.ui.ListActivity

const val KEY_TYPE = "KEY_TYPE"
const val KEY_USERNAME = "KEY_USERNAME"

fun AppCompatActivity.showListActivity(context: Context, type: String, username: String? = null) {
    startActivity(
        Intent(context, ListActivity::class.java)
            .putExtra(KEY_TYPE, type)
            .putExtra(KEY_USERNAME, username)
    )
}
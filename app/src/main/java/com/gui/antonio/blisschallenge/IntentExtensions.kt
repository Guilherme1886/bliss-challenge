package com.gui.antonio.blisschallenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showListActivity(context: Context, typeList: Int, type: String) {
    startActivity(
        Intent(context, ListActivity::class.java)
            .putExtra("KEY_LIST_TYPE", typeList)
            .putExtra("KEY_TYPE", type)
    )
}
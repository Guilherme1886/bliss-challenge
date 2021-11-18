package com.gui.antonio.blisschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gui.antonio.blisschallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.emojiListButton.setOnClickListener {
            showListActivity(this, TypeList.EMOJI.value)
        }
        binding.avatarListButton.setOnClickListener {
            showListActivity(this, TypeList.AVATAR.value)
        }
        binding.repoButton.setOnClickListener {
            showListActivity(this, TypeList.REPOSITORY.value)
        }
    }

}
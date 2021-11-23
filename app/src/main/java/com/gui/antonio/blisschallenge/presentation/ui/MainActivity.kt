package com.gui.antonio.blisschallenge.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gui.antonio.blisschallenge.databinding.ActivityMainBinding
import com.gui.antonio.blisschallenge.showListActivity

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
        binding.usernameTextInputLayout.setStartIconOnClickListener {
            showListActivity(this, TypeList.AVATAR.value, binding.usernameTextEditText.text.toString())
        }
        binding.avatarListButton.setOnClickListener {
            showListActivity(this, TypeList.AVATAR.value)
        }
        binding.repoButton.setOnClickListener {
            showListActivity(this, TypeList.REPOSITORY.value)
        }
    }

}
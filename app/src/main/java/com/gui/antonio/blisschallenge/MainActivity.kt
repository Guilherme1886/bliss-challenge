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


        binding.emojiListButton.setOnClickListener {
//            viewModel.typeList = 0
            showListActivity(this, 0)

        }
        binding.avatarListButton.setOnClickListener {

        }
        binding.repoButton.setOnClickListener {

        }


    }

}
package com.gui.antonio.blisschallenge.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gui.antonio.blisschallenge.KEY_TYPE
import com.gui.antonio.blisschallenge.KEY_USERNAME
import com.gui.antonio.blisschallenge.databinding.ActivityListBinding
import com.gui.antonio.blisschallenge.presentation.adapter.ListAdapter
import com.gui.antonio.blisschallenge.presentation.viewmodel.MainViewModel
import com.gui.antonio.blisschallenge.presentation.viewmodel.factory.MainViewModelFactory

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setContentView(binding.root)
        setViewModel()
        setView()
        setObservers()
        getData()
    }

    private fun getType(type: String?): TypeList {
        return when (type) {
            TypeList.EMOJI.value -> TypeList.EMOJI
            TypeList.AVATAR.value -> TypeList.AVATAR
            else -> TypeList.REPOSITORY
        }
    }

    private fun getData() {
        val type = intent.getStringExtra(KEY_TYPE)

        when (getType(type)) {
            TypeList.EMOJI -> viewModel.getEmojis()
            TypeList.AVATAR -> {
                val username = intent.getStringExtra(KEY_USERNAME)
                if (username != null) viewModel.getAvatar(username) else viewModel.getAvatar()
            }
            TypeList.REPOSITORY -> viewModel.getRepository()
        }
    }

    private fun setObservers() {
        viewModel.getEmojisLiveData.observe(this) {
            binding.progressIndicator.hide()
            binding.recyclerView.layoutManager = GridLayoutManager(this@ListActivity, FOUR)
            listAdapter.items = it
        }

        viewModel.getAvatarLiveData.observe(this) {
            binding.progressIndicator.hide()
            binding.recyclerView.layoutManager = GridLayoutManager(this@ListActivity, FOUR)
            listAdapter.items = it
        }

        viewModel.getReposLiveData.observe(this) {
            binding.progressIndicator.hide()
            binding.recyclerView.layoutManager = LinearLayoutManager(this@ListActivity)
            listAdapter.items = it
        }
    }

    private fun setView() {
        val type = when (getType(intent.getStringExtra(KEY_TYPE))) {
            TypeList.EMOJI -> ZERO
            TypeList.AVATAR -> ZERO
            else -> ONE
        }

        listAdapter = ListAdapter(type)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = listAdapter
            listAdapter.imageOnClick = {
                listAdapter.items.removeAt(it)
                listAdapter.items = listAdapter.items
            }
        }
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }

    private fun setBinding() {
        binding = ActivityListBinding.inflate(layoutInflater)
    }

    companion object {
        private const val ZERO = 0
        private const val ONE = 1
        private const val FOUR = 4
    }

}
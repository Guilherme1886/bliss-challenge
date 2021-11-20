package com.gui.antonio.blisschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gui.antonio.blisschallenge.databinding.ActivityListBinding

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
            TypeList.AVATAR -> viewModel.getAvatar()
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
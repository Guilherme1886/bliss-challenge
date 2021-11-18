package com.gui.antonio.blisschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gui.antonio.blisschallenge.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]

        val listType = intent.getIntExtra("KEY_LIST_TYPE", -1)
        listAdapter = ListAdapter(listType)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = listAdapter
        }

        viewModel.getEmojisLiveData.observe(this) {
            listAdapter.items = it
        }

        viewModel.getAvatarLiveData.observe(this) {
            listAdapter.items = it
        }

        viewModel.getReposLiveData.observe(this) {
            listAdapter.items = it
        }

        val type = intent.getStringExtra("KEY_TYPE")

        when (type) {
            "EMOJI" -> viewModel.getEmojis()
            "AVATAR" -> viewModel.getAvatar()
            "REPOSITORY" -> viewModel.getRepository()
        }
    }

}
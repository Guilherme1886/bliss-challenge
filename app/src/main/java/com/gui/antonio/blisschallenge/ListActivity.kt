package com.gui.antonio.blisschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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

        viewModel.getEmojisLiveData.observe(this) {

            val listType = intent.getIntExtra("KEY_LIST_TYPE", -1)
            listAdapter = ListAdapter(listType)

            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = listAdapter
            }

            listAdapter.items = it
        }

        viewModel.getEmojis()
    }

}
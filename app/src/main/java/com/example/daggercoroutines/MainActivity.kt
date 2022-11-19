package com.example.daggercoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggercoroutines.adapter.MyPostsAdapter
import com.example.daggercoroutines.databinding.ActivityMainBinding
import com.example.daggercoroutines.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyPostsAdapter
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.posts.observe(this, { response->
            binding.postRecycler.layoutManager = LinearLayoutManager(this)
            adapter = MyPostsAdapter(response)
            binding.postRecycler.adapter = adapter
        })

    }
}
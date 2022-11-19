package com.example.daggercoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggercoroutines.model.PostsItem
import com.example.daggercoroutines.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: PostRepository): ViewModel() {
    val _posts = MutableLiveData<List<PostsItem>>()

    val posts: LiveData<List<PostsItem>>
    get() = _posts

    init {
        getAllPosts()

    }

    private fun getAllPosts() = viewModelScope.launch {
        repository.getPosts().let { response ->
        if (response.isSuccessful){
            _posts.postValue(response.body())
        }else{
            Log.e("MainActivityViewModel", "error")
        }

        }
    }
}
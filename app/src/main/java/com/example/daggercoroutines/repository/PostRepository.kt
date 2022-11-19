package com.example.daggercoroutines.repository

import com.example.daggercoroutines.api.PostsApi
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: PostsApi) {

    suspend fun getPosts() = api.getAllPosts()
}
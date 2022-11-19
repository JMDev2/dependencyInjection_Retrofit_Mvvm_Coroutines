package com.example.daggercoroutines.api

import com.example.daggercoroutines.model.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<PostsItem>>
}
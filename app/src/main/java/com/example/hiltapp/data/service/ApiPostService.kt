package com.example.hiltapp.data.service

import com.example.hiltapp.data.dto.PostDto
import retrofit2.http.GET

interface ApiPostService {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
package com.example.hiltapp.domain.repository

import com.example.hiltapp.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}
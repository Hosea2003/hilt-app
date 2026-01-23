package com.example.hiltapp.data.repository

import com.example.hiltapp.domain.model.Post
import com.example.hiltapp.domain.repository.PostRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(): PostRepository {
    override suspend fun getPosts(): List<Post> {
        delay(1000)
        return listOf(
            Post(id = "1", title = "title 1"),
            Post(id = "2", title = "title 2"),
            Post(id = "3", title = "title 3")
        )
    }
}
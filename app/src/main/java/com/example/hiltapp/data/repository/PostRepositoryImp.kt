package com.example.hiltapp.data.repository

import com.example.hiltapp.data.service.ApiPostService
import com.example.hiltapp.domain.model.Post
import com.example.hiltapp.domain.model.toPost
import com.example.hiltapp.domain.repository.PostRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    val postApiService: ApiPostService
): PostRepository {
    override suspend fun getPosts(): List<Post> {
        val post =  postApiService
                .getPosts()
            .map { postDto ->  postDto.toPost() }
        return post
    }
}
package com.example.hiltapp.domain.model

import com.example.hiltapp.data.dto.PostDto

data class Post(
    val id: String,
    val title: String
)

fun PostDto.toPost(): Post {
    return Post(
        id = id,
        title = title
    )
}


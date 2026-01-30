package com.example.hiltapp.domain.use_case

import com.example.hiltapp.common.Resource
import com.example.hiltapp.domain.model.Post
import com.example.hiltapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        try{
            emit(Resource.Loading())
            val posts = postRepository.getPosts()
            emit(Resource.Success(posts))
        }
        catch (e: HttpException){
            emit(Resource.Error(message = "Http Error, status code=${e.code()}"))
        }
        catch (e: IOException){
            emit(Resource.Error(message = "Network error"))
        }
    }
}
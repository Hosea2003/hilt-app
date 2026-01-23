package com.example.hiltapp.data.di

import com.example.hiltapp.data.repository.PostRepositoryImp
import com.example.hiltapp.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPostRepository(
        postRepository: PostRepositoryImp
    ): PostRepository
}
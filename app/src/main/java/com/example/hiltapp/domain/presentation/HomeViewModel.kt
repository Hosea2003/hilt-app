package com.example.hiltapp.domain.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltapp.common.Resource
import com.example.hiltapp.domain.repository.PostRepository
import com.example.hiltapp.domain.use_case.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
): ViewModel() {

    val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    fun getPosts(){
        viewModelScope.launch {
            val response = getPostUseCase()
            response.collect { result->
                when(result){
                    is Resource.Loading->{
                        _loading.postValue(true)
                    }
                    is Resource.Error->{
                        _loading.postValue(false)
                        println(result.message)
                    }
                    is Resource.Success->{
                        _loading.postValue(false)
                        println(result.data)
                    }
                }
            }
        }
    }
}
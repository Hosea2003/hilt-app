package com.example.hiltapp.domain.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewmodel = hiltViewModel<HomeViewModel>()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = {
                viewmodel.getPosts()
            }
        ) {
            if(viewmodel.loading.value == true){
                Text(text = "Loading...")
            }
            else{
                Text(text = "Get Posts")
            }
        }
    }
}
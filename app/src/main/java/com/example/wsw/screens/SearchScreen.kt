package com.example.wsw.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.example.wsw.models.DataState
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.models.SwitchK
import com.example.wsw.theme.newBackground
import com.example.wsw.ui.bottombar.bottomBar
import com.example.wsw.ui.cardItem.FullCard
import com.example.wsw.ui.topbar.topAppBarView

@Composable
fun searchScreen(viewModel: SwitchCardViewModel){
    when (val result = viewModel.response.value) {
        is DataState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is DataState.Success -> {
            Scaffold(
                bottomBar = { bottomBar() },
                topBar = { topAppBarView(viewModel) },
                containerColor = newBackground
            ) {  innerPadding ->
                ShowLazyList(result.data, innerPadding, viewModel)
            }
        }

        is DataState.Failure -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.message
                )
            }
        }
        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error Fetching data",
                )
            }
        }
    }
}

@Composable
fun ShowLazyList(switchs: MutableList<SwitchK>, innerPadding: PaddingValues, viewModel: SwitchCardViewModel) {
    LazyColumn(modifier = Modifier.padding(innerPadding).zIndex(-1f)){
        items(switchs) { switch ->
            FullCard(switch, viewModel)
        }
    }
}


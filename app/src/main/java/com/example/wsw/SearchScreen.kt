package com.example.wsw

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(topBar = { SearchField() }, bottomBar = { BottomNav(navController) },) { innerPadding ->
        Column(modifier = Modifier.verticalScroll(ScrollState(0)).padding(innerPadding)) {
            FullCard()
            FullCard()
            FullCard()
            FullCard()
            FullCard()
            FullCard()
            FullCard()
            FullCard()
        }
    }
}
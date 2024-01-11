package com.example.wsw

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CompareScreen(navController: NavController){
    Scaffold(bottomBar = { BottomNav(navController) },) { innerPadding ->
        Column(modifier = Modifier.verticalScroll(ScrollState(0)).padding(innerPadding)) {
            Text("POOP")
        }
    }
}
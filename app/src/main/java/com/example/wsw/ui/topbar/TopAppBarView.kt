package com.example.wsw.ui.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.theme.cityPrimary

@Composable
fun topAppBarView(viewModel: SwitchCardViewModel) {
    val col = cityPrimary
    Column(){
        WSPrimaryTopBar(col, viewModel)
    }
}
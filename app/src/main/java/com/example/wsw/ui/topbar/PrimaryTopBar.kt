package com.example.wsw.ui.topbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wsw.models.SwitchCardViewModel
import com.example.wsw.theme.newBackground
import com.example.wsw.theme.newPrimary

@Composable
fun WSPrimaryTopBar(col: Color, viewModel: SwitchCardViewModel){
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(color = newBackground)
    ){
        Text("WhatSwitch pre_alpha", Modifier.padding(horizontal = 15.dp), fontWeight = FontWeight.Bold, color = newPrimary, fontSize = 20.sp)
        IconButton(onClick = { viewModel.cv() }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Localized description",
                tint = newPrimary
            )
        }
    }
    AnimatedVisibility(visible=viewModel.ffvisible, enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
        exit = slideOutVertically() + shrinkVertically()){

        HiddenTopBar()
    }
}

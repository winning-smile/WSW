package com.example.wsw.ui.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WSSecondaryTopBar(){

    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ){{}
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start) { CompareButton() }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) { CompareCountButton() }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) { SearchButton() }
    }
}
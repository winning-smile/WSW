package com.example.wsw.ui.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun WSPrimaryTopBar(){
    Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 12.dp, 12.dp)).
        fillMaxWidth()
    ){
        IconButton(onClick = { /* do something */ }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Localized description"
            )
        }
        Text("App Name Template")
        IconButton(onClick = { /* do something */ }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Localized description"
            )
        }
    }
}
